package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class UserFormAnswerVO implements Serializable {

    private Long id;

    private String value;

    private Long questionId;

    private List<ValuesVO> values;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
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
        private Integer order;
        private String value;

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

        @Override
        public String toString() {
            return "ValuesVO{" +
                    "order=" + order +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
