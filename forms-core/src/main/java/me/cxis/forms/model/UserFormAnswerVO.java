package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class UserFormAnswerVO implements Serializable {

    private int id;

    private String value;

    private int questionId;

    private List<ValuesVO> values;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public List<ValuesVO> getValues() {
        return values;
    }

    public void setValues(List<ValuesVO> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "UserFormAnswerVO{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", questionId=" + questionId +
                ", values=" + values +
                '}';
    }

    public static class ValuesVO {
        private int order;
        private String value;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ValuesVO{" +
                    "order=" + order +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
