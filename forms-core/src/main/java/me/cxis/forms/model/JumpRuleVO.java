package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class JumpRuleVO implements Serializable {

    private List<Long> jumpTo;

    private List<ExpressionVO> expressions;

    public List<Long> getJumpTo() {
        return jumpTo;
    }

    public void setJumpTo(List<Long> jumpTo) {
        this.jumpTo = jumpTo;
    }

    public List<ExpressionVO> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<ExpressionVO> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString() {
        return "JumpRuleVO{" +
                "jumpTo=" + jumpTo +
                ", expressions=" + expressions +
                '}';
    }

    public static class ExpressionVO {
        private int item;

        private String expression;

        private String value;

        private String next;

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ExpressionVO{" +
                    "item=" + item +
                    ", expression='" + expression + '\'' +
                    ", value='" + value + '\'' +
                    ", next='" + next + '\'' +
                    '}';
        }
    }
}
