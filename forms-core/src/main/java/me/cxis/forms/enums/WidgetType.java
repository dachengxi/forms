package me.cxis.forms.enums;

public enum WidgetType {
    INPUT(1, "input", false, "单行文本"),
    TEXTAREA(2, "textarea", false, "多行文本"),
    MULTI_INPUT(3, "multiInput", true, "多项单行文本"),
    RADIO(4, "radio", false, "单选"),
    CHECKBOX(5, "checkbox", true, "多选"),
    NUMBER_INPUT(6, "numberInput", false, "数字输入框")
    ;

    public static WidgetType of(int type) {
        for (WidgetType widgetType : values()) {
            if (widgetType.type == type) {
                return widgetType;
            }
        }

        return null;
    }

    WidgetType(int type, String code, boolean multiValues, String desc) {
        this.type = type;
        this.code = code;
        this.multiValues = multiValues;
        this.desc = desc;
    }

    private int type;

    private String code;

    private boolean multiValues;

    private String desc;

    public int getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public boolean isMultiValues() {
        return multiValues;
    }

    public String getDesc() {
        return desc;
    }
}
