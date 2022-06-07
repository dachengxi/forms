package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class FormQuestionVO implements Serializable {

    private Long id;

    private Long formId;

    private String title;

    private String description;

    private Integer order;

    private Integer pageNumber;

    private Integer widgetType;

    private WidgetRuleVO widgetRule;


    private Boolean hidden;

    private List<JumpRuleVO> jumpRules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public List<JumpRuleVO> getJumpRules() {
        return jumpRules;
    }

    public void setJumpRules(List<JumpRuleVO> jumpRules) {
        this.jumpRules = jumpRules;
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
                ", hidden=" + hidden +
                ", jumpRules=" + jumpRules +
                '}';
    }
}
