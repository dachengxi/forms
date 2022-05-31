package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class FormVO implements Serializable {
    private Long id;

    private Long templateId;

    private String code;

    private Integer version;

    private Integer type;

    private String title;

    private String description;

    private Integer status;

    private Integer totalPage;

    private Integer mode;

    private List<FormQuestionVO> questions;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public List<FormQuestionVO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<FormQuestionVO> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "FormVO{" +
                "id=" + id +
                ", templateId=" + templateId +
                ", code='" + code + '\'' +
                ", version=" + version +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", totalPage=" + totalPage +
                ", mode=" + mode +
                ", questions=" + questions +
                '}';
    }
}
