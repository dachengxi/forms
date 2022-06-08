package me.cxis.forms.rules;

import me.cxis.forms.model.JumpRuleVO;
import me.cxis.forms.model.UserFormAnswerVO;

public interface JumpRule {

    int type();

    boolean canJump(JumpRuleVO rule, UserFormAnswerVO answer);
}
