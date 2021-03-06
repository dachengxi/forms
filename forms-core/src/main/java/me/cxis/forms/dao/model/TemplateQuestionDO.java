package me.cxis.forms.dao.model;

import java.time.LocalDateTime;

public class TemplateQuestionDO {

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long creatorId;

    private Long modifierId;

    private Boolean isDeleted;

    private Long templateId;

    private String title;

    private String description;

    private Integer order;

    private Integer pageNumber;

    private Integer widgetType;

    private String widgetRule;

    private String jumpRule;

    private Boolean hidden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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

    public String getWidgetRule() {
        return widgetRule;
    }

    public void setWidgetRule(String widgetRule) {
        this.widgetRule = widgetRule;
    }

    public String getJumpRule() {
        return jumpRule;
    }

    public void setJumpRule(String jumpRule) {
        this.jumpRule = jumpRule;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
}