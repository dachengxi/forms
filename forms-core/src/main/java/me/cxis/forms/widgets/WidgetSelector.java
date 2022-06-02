package me.cxis.forms.widgets;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class WidgetSelector {

    @Resource
    private List<Widget> widgets;

    public Widget select(int type) {
        for (Widget widget : widgets) {
            if (widget.type() == type) {
                return widget;
            }
        }

        return null;
    }
}
