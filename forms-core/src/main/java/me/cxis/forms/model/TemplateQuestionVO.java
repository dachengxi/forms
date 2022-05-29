package me.cxis.forms.model;

import java.io.Serializable;

public class TemplateQuestionVO implements Serializable {

    private int id;

    private int templateId;

    private String title;

    private String description;

    private int status;

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

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        return "TemplateQuestionVO{" +
                "id=" + id +
                ", templateId=" + templateId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", order=" + order +
                ", pageNumber=" + pageNumber +
                ", widgetType=" + widgetType +
                ", widgetRule=" + widgetRule +
                '}';
    }
}
