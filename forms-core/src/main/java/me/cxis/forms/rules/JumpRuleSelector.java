package me.cxis.forms.rules;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class JumpRuleSelector {

    @Resource
    private List<JumpRule> jumpRules;

    public JumpRule choose(int type) {
        for (JumpRule jumpRule : jumpRules) {
            if (jumpRule.type() == type) {
                return jumpRule;
            }
        }

        return null;
    }
}
