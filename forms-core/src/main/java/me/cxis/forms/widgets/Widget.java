package me.cxis.forms.widgets;

import me.cxis.forms.model.UserFormAnswerVO;
import me.cxis.forms.model.WidgetRuleVO;

public interface Widget {

    int type();

    void validate(UserFormAnswerVO answer, WidgetRuleVO widgetRule);
}
