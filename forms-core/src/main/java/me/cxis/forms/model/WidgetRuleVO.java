package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class WidgetRuleVO implements Serializable {

    private String headTitle;

    private String tailTitle;

    private boolean required;

    private int min;

    private int max;

    private String direction;

    private String value;

    private String defaultValue;

    private String placeholder;

    private int order;

    private boolean defaultSelected;

    private List<WidgetRuleVO> items;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isDefaultSelected() {
        return defaultSelected;
    }

    public void setDefaultSelected(boolean defaultSelected) {
        this.defaultSelected = defaultSelected;
    }

    public List<WidgetRuleVO> getItems() {
        return items;
    }

    public void setItems(List<WidgetRuleVO> items) {
        this.items = items;
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
                ", value='" + value + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", placeholder='" + placeholder + '\'' +
                ", order=" + order +
                ", defaultSelected=" + defaultSelected +
                ", items=" + items +
                '}';
    }
}
