package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class TemplateVO implements Serializable {

    private int id;

    private String code;

    private int type;

    private String title;

    private String description;

    private int status;

    private int totalPage;

    private int mode;

    private int currentPage;

    private List<TemplateQuestionVO> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<TemplateQuestionVO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TemplateQuestionVO> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "TemplateVO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", totalPage=" + totalPage +
                ", mode=" + mode +
                ", currentPage=" + currentPage +
                ", questions=" + questions +
                '}';
    }
}
