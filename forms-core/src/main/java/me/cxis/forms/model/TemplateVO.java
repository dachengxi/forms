package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class TemplateVO implements Serializable {

    private Long id;

    private String code;

    private Integer type;

    private String title;

    private String description;

    private Integer status;

    private Long totalPage;

    /**
     * 模式：1-分页模式 2-一题一页 3-一页
     */
    private Integer mode;

    private List<TemplateQuestionVO> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
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
                ", questions=" + questions +
                '}';
    }
}
