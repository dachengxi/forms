package me.cxis.forms.model.param;

import java.io.Serializable;
import java.util.List;

public class UserFormSaveParam implements Serializable {

    private Long userId;

    private Long userFormId;

    private Long formId;

    private List<UserFormAnswerSaveParam> answers;

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

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public List<UserFormAnswerSaveParam> getAnswers() {
        return answers;
    }

    public void setAnswers(List<UserFormAnswerSaveParam> answers) {
        this.answers = answers;
    }

    public static class UserFormAnswerSaveParam {
        private Long questionId;

        private String value;

        private List<ValueParam> values;

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<ValueParam> getValues() {
            return values;
        }

        public void setValues(List<ValueParam> valueParams) {
            this.values = valueParams;
        }

        public static class ValueParam {
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
                return "ValueParam{" +
                        "order=" + order +
                        ", value='" + value + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "UserFormAnswerSaveParam{" +
                    "questionId=" + questionId +
                    ", value='" + value + '\'' +
                    ", values=" + values +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserFormSaveParam{" +
                "userId=" + userId +
                ", userFormId=" + userFormId +
                ", formId=" + formId +
                ", answers=" + answers +
                '}';
    }
}
