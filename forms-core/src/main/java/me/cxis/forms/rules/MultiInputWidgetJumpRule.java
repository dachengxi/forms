package me.cxis.forms.rules;

import me.cxis.forms.enums.WidgetType;
import me.cxis.forms.model.JumpRuleVO;
import me.cxis.forms.model.UserFormAnswerVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MultiInputWidgetJumpRule implements JumpRule {

    @Override
    public int type() {
        return WidgetType.MULTI_INPUT.getType();
    }

    @Override
    public boolean canJump(JumpRuleVO rule, UserFormAnswerVO answer) {
        // 拼接表达式
        List<JumpRuleVO.ExpressionVO> expressions = rule.getExpressions();
        if (CollectionUtils.isEmpty(expressions)) {
            return false;
        }

        if (StringUtils.isEmpty(answer.getValue())) {
            return false;
        }

        StringBuilder spel = new StringBuilder();
        ExpressionParser parser = new SpelExpressionParser();
        for (JumpRuleVO.ExpressionVO expression : expressions) {
            UserFormAnswerVO.ValuesVO itemValue = answer.getValues().get(expression.getItem() - 1);
            String s = "";
            if (expression.getExpression().equals("contains")) {
                s += String.format("'%s'.%s('%s')", itemValue.getValue(), expression.getExpression(), expression.getValue());
            } else if (expression.getExpression().equals("eq")) {
                s += String.format("'%s' %s '%s'", itemValue.getValue(), expression.getExpression(), expression.getValue());
            }
            System.out.println(s);
            Expression exp = parser.parseExpression(s);
            Object value = exp.getValue();
            if (value == null) {
                spel.append("false");
            } else {
                spel.append(value);
            }

            if (StringUtils.isNotEmpty(expression.getNext())) {
                String next = String.format(" %s ", expression.getNext());
                spel.append(next);
            }

        }

        System.out.println("multi input widget jump rule spel: " + spel);

        if (StringUtils.isEmpty(spel.toString())) {
            return false;
        }

        Expression exp = parser.parseExpression(spel.toString());
        Object value = exp.getValue();
        if (value == null) {
            return false;
        }
        return (boolean) value;
    }
}
