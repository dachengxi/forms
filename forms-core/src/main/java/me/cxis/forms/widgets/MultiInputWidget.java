package me.cxis.forms.widgets;

import me.cxis.forms.enums.WidgetType;
import me.cxis.forms.model.UserFormAnswerVO;
import me.cxis.forms.model.WidgetRuleVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultiInputWidget implements Widget {

    @Override
    public int type() {
        return WidgetType.MULTI_INPUT.getType();
    }

    public void validate(UserFormAnswerVO answer, WidgetRuleVO widgetRule) {
        List<UserFormAnswerVO.ValuesVO> values = answer.getValues();
        if (CollectionUtils.isEmpty(values)) {
            throw new RuntimeException("required at least one item");
        }

        // 排序
        List<WidgetRuleVO> ruleItems = widgetRule.getItems()
                .stream()
                .sorted(Comparator.comparing(WidgetRuleVO::getOrder))
                .collect(Collectors.toList());

        // 排序
        values = values
                .stream()
                .sorted(Comparator.comparing(UserFormAnswerVO.ValuesVO::getOrder))
                .collect(Collectors.toList());

        if (ruleItems.size() != values.size()) {
            throw new RuntimeException("wrong item size");
        }

        for (int i = 0; i < ruleItems.size(); i++) {
            WidgetRuleVO ruleItem = ruleItems.get(i);
            UserFormAnswerVO.ValuesVO answerItem = values.get(i);
            if (ruleItem.getRequired() && StringUtils.isBlank(answerItem.getValue())) {
                throw new RuntimeException("required");
            }

            if (ruleItem.getMin() != null && ruleItem.getMin() > 0 && answerItem.getValue().length() < ruleItem.getMin()) {
                throw new RuntimeException("min: " + ruleItem.getMin());
            }

            if (ruleItem.getMax() != null && ruleItem.getMax() > 0 && answerItem.getValue().length() > ruleItem.getMax()) {
                throw new RuntimeException("max: " + ruleItem.getMax());
            }
        }


    }
}
