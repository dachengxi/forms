package me.cxis.forms.dao.model;

import java.time.LocalDateTime;

public class TemplateQuestionDO {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long creatorId;

    private Long modifierId;

    private Byte isDeleted;

    private Long templateId;

    private String title;

    private String description;

    private Short status;

    private Integer order;

    private Integer pageNumber;

    private Short widgetType;

    private String widgetRule;

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

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
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

    public Short getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(Short widgetType) {
        this.widgetType = widgetType;
    }

    public String getWidgetRule() {
        return widgetRule;
    }

    public void setWidgetRule(String widgetRule) {
        this.widgetRule = widgetRule;
    }
}