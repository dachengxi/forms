package me.cxis.forms.widgets;

import me.cxis.forms.enums.WidgetType;
import me.cxis.forms.model.UserFormAnswerVO;
import me.cxis.forms.model.WidgetRuleVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

        // 合并答案和Rule
        List<AnswerWithRule> answerWithRules = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            UserFormAnswerVO.ValuesVO answerItem = values.get(i);
            WidgetRuleVO rule = ruleItems.get(i);

            AnswerWithRule answerWithRule = new AnswerWithRule();
            answerWithRule.setOrder(answerItem.getOrder());
            answerWithRule.setValue(answerItem.getValue());
            answerWithRule.setExclusive(rule.getExclusive());
            answerWithRules.add(answerWithRule);
        }

        Map<Boolean, List<AnswerWithRule>> exclusiveMapping = answerWithRules
                .stream()
                .collect(Collectors.groupingBy(AnswerWithRule::getExclusive));

        // 只有exclusive=false的
        if (exclusiveMapping.size() == 1 && CollectionUtils.isNotEmpty(exclusiveMapping.get(false))) {
            return;
        }

        // 只有exclusive=true的并且有多个
        if (exclusiveMapping.size() == 1 &&
                CollectionUtils.isNotEmpty(exclusiveMapping.get(true)) &&
                exclusiveMapping.get(true).size() > 1) {
            List<AnswerWithRule> exclusiveAnswers = exclusiveMapping.get(true)
                    .stream()
                    .filter(answerWithRule -> StringUtils.isNotEmpty(answerWithRule.getValue()))
                    .collect(Collectors.toList());
            if (exclusiveAnswers.size() > 1) {
                throw new RuntimeException("exclusive");
            }
        }

        // exclusive=true和false的都有
        if (exclusiveMapping.size() == 2) {
            List<AnswerWithRule> exclusives = exclusiveMapping.get(true)
                    .stream()
                    .filter(answerWithRule -> StringUtils.isNotEmpty(answerWithRule.getValue()))
                    .collect(Collectors.toList());
            List<AnswerWithRule> notExclusives = exclusiveMapping.get(false)
                    .stream()
                    .filter(answerWithRule -> StringUtils.isNotEmpty(answerWithRule.getValue()))
                    .collect(Collectors.toList());

            if (exclusives.size() > 1) {
                throw new RuntimeException("exclusive");
            }

            if (exclusives.size() == 1 && notExclusives.size() > 0) {
                throw new RuntimeException("exclusive");
            }
        }
    }

    static class AnswerWithRule {
        private Integer order;
        private String value;
        private Boolean exclusive;

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Boolean getExclusive() {
            return exclusive;
        }

        public void setExclusive(Boolean exclusive) {
            this.exclusive = exclusive;
        }

        @Override
        public String toString() {
            return "AnswerWithRule{" +
                    "order=" + order +
                    ", value='" + value + '\'' +
                    ", exclusive=" + exclusive +
                    '}';
        }
    }
}
