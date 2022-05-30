package me.cxis.forms.model;

import java.util.List;

public class UserFormVO {

    private int id;

    private int status;

    private int formId;

    private String formCode;

    private int formVersion;

    private int formType;

    private String formTitle;

    private String formDescription;

    private int totalPage;

    private int formMode;

    private int currentPage;

    private List<FormQuestionVO> questions;

    private List<UserFormAnswerVO> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public int getFormVersion() {
        return formVersion;
    }

    public void setFormVersion(int formVersion) {
        this.formVersion = formVersion;
    }

    public int getFormType() {
        return formType;
    }

    public void setFormType(int formType) {
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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getFormMode() {
        return formMode;
    }

    public void setFormMode(int formMode) {
        this.formMode = formMode;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
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
