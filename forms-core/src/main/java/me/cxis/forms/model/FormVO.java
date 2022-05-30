package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class FormVO implements Serializable {
    private int id;

    private int templateId;

    private String code;

    private int version;

    private int type;

    private String title;

    private String description;

    private int status;

    private int totalPage;

    private int mode;

    private List<FormQuestionVO> questions;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
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
