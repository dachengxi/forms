
package me.cxis.forms.widgets;

import me.cxis.forms.enums.WidgetType;
import me.cxis.forms.model.UserFormAnswerVO;
import me.cxis.forms.model.WidgetRuleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class NumberInputWidget implements Widget {

    @Override
    public int type() {
        return WidgetType.NUMBER_INPUT.getType();
    }

    public void validate(UserFormAnswerVO answer, WidgetRuleVO widgetRule) {
        if (widgetRule.getRequired() && StringUtils.isBlank(answer.getValue())) {
            throw new RuntimeException("required");
        }

        if (widgetRule.getMin() != null && Integer.parseInt(answer.getValue()) < widgetRule.getMin()) {
            throw new RuntimeException("min: " + widgetRule.getMin());
        }

        if (widgetRule.getMax() != null && Integer.parseInt(answer.getValue()) > widgetRule.getMax()) {
            throw new RuntimeException("max: " + widgetRule.getMax());
        }
    }
}
