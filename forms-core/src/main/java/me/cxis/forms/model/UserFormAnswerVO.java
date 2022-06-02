package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class UserFormAnswerVO implements Serializable {

    private Long id;

    private Long userId;

    private Long userFormId;

    private Long questionId;

    private Integer widgetType;

    private String value;

    private List<ValuesVO> values;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserFormId() {
        return userFormId;
    }

    public void setUserFormId(Long userFormId) {
        this.userFormId = userFormId;
    }

    public Integer getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(Integer widgetType) {
        this.widgetType = widgetType;
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
                ", userId=" + userId +
                ", userFormId=" + userFormId +
                ", questionId=" + questionId +
                ", widgetType=" + widgetType +
                ", value='" + value + '\'' +
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
