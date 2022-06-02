package me.cxis.forms.model;

import java.util.List;

public class UserFormVO {

    private Long id;

    private Integer status;

    private Long userId;

    private Long formId;

    private String formCode;

    private Long formVersion;

    private Integer formType;

    private String formTitle;

    private String formDescription;

    private Long totalPage;

    private Integer formMode;

    private Integer currentPage;

    private List<FormQuestionVO> questions;

    private List<UserFormAnswerVO> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public Long getFormVersion() {
        return formVersion;
    }

    public void setFormVersion(Long formVersion) {
        this.formVersion = formVersion;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public String getFormDescription() {
        return formDescription;
    }

    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getFormMode() {
        return formMode;
    }

    public void setFormMode(Integer formMode) {
        this.formMode = formMode;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<FormQuestionVO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<FormQuestionVO> questions) {
        this.questions = questions;
    }

    public List<UserFormAnswerVO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<UserFormAnswerVO> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "UserFormVO{" +
                "id=" + id +
                ", status=" + status +
                ", userId=" + userId +
                ", formId=" + formId +
                ", formCode='" + formCode + '\'' +
                ", formVersion=" + formVersion +
                ", formType=" + formType +
                ", formTitle='" + formTitle + '\'' +
                ", formDescription='" + formDescription + '\'' +
                ", totalPage=" + totalPage +
                ", formMode=" + formMode +
                ", currentPage=" + currentPage +
                ", questions=" + questions +
                ", answers=" + answers +
                '}';
    }
}
