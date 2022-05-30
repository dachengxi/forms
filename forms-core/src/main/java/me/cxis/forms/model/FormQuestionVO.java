package me.cxis.forms.model;

import java.io.Serializable;

public class FormQuestionVO implements Serializable {

    private int id;

    private int formId;

    private String title;

    private String description;

    private int order;

    private int pageNumber;

    private int widgetType;

    private WidgetRuleVO widgetRule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(int widgetType) {
        this.widgetType = widgetType;
    }

    public WidgetRuleVO getWidgetRule() {
        return widgetRule;
    }

    public void setWidgetRule(WidgetRuleVO widgetRule) {
        this.widgetRule = widgetRule;
    }

    @Override
    public String toString() {
        return "FormQuestionVO{" +
                "id=" + id +
                ", formId=" + formId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", order=" + order +
                ", pageNumber=" + pageNumber +
                ", widgetType=" + widgetType +
                ", widgetRule=" + widgetRule +
                '}';
    }
}
