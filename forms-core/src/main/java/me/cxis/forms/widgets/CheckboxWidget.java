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
public class CheckboxWidget implements Widget {

    @Override
    public int type() {
        return WidgetType.CHECKBOX.getType();
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

        int answerSize = 0;
        for (int i = 0; i < values.size(); i++) {
            UserFormAnswerVO.ValuesVO answerItem = values.get(i);
            if (StringUtils.isNotBlank(answerItem.getValue())) {
                answerSize++;
            }
        }

        if (widgetRule.getMin() != null && widgetRule.getMin() > 0 && answerSize < widgetRule.getMin()) {
            throw new RuntimeException("min: " + widgetRule.getMin());
        }

        if (widgetRule.getMax() != null && widgetRule.getMax() > 0 && answerSize > widgetRule.getMax()) {
            throw new RuntimeException("max: " + widgetRule.getMax());
        }

    }
}
