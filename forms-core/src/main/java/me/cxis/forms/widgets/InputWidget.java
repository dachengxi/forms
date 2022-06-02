package me.cxis.forms.widgets;

import me.cxis.forms.enums.WidgetType;
import me.cxis.forms.model.UserFormAnswerVO;
import me.cxis.forms.model.WidgetRuleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class InputWidget implements Widget {

    @Override
    public int type() {
        return WidgetType.INPUT.getType();
    }

    public void validate(UserFormAnswerVO answer, WidgetRuleVO widgetRule) {
        if (widgetRule.getRequired() && StringUtils.isBlank(answer.getValue())) {
            throw new RuntimeException("required");
        }

        if (widgetRule.getMin() != null && widgetRule.getMin() > 0 && answer.getValue().length() < widgetRule.getMin()) {
            throw new RuntimeException("min: " + widgetRule.getMin());
        }

        if (widgetRule.getMax() != null && widgetRule.getMax() > 0 && answer.getValue().length() > widgetRule.getMax()) {
            throw new RuntimeException("max: " + widgetRule.getMax());
        }
    }
}
