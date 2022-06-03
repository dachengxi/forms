package me.cxis.forms.model;

import java.io.Serializable;
import java.util.List;

public class WidgetRuleVO implements Serializable {

    private String headTitle;

    private String tailTitle;

    private Boolean required;

    private Integer min;

    private Integer max;

    private String direction;

    private String value;

    private String defaultValue;

    private String placeholder;

    private Integer order;

    private Boolean defaultSelected;

    private Boolean exclusive;

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

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getDefaultSelected() {
        return defaultSelected;
    }

    public void setDefaultSelected(Boolean defaultSelected) {
        this.defaultSelected = defaultSelected;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
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
                ", exclusive=" + exclusive +
                ", items=" + items +
                '}';
    }
}
