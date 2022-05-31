package me.cxis.forms.model;

import java.io.Serializable;

public class TemplateQuestionVO implements Serializable {

    private Long id;

    private Long templateId;

    private String title;

    private String description;

    private Integer status;

    private Integer order;

    private Integer pageNumber;

    private Integer widgetType;

    private WidgetRuleVO widgetRule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(Integer widgetType) {
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
