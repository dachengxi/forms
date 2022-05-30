package me.cxis.forms.model.param;

import java.io.Serializable;
import java.util.List;

public class UserFormSaveParam implements Serializable {

    private int userFormId;

    private int formId;

    private List<Questions> questions;

    public int getUserFormId() {
        return userFormId;
    }

    public void setUserFormId(int userFormId) {
        this.userFormId = userFormId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public static class Questions {
        private int id;

        private String value;

        private List<Value> values;

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

        public List<Value> getValues() {
            return values;
        }

        public void setValues(List<Value> values) {
            this.values = values;
        }

        public static class Value {
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
        }
    }
}
