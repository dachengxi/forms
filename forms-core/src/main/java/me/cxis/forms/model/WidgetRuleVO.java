package me.cxis.forms.model;

import java.io.Serializable;

public class WidgetRuleVO implements Serializable {

    private String headTitle;

    private String tailTitle;

    private boolean required;

    private int min;

    private int max;

    private String direction;

    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    public String getTailTitle() {
        return tailTitle;
    }

    public void setTailTitle(String tailTitle) {
        this.tailTitle = tailTitle;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "WidgetRuleVO{" +
                "headTitle='" + headTitle + '\'' +
                ", tailTitle='" + tailTitle + '\'' +
                ", required=" + required +
                ", min=" + min +
                ", max=" + max +
                ", direction='" + direction + '\'' +
                '}';
    }
}
