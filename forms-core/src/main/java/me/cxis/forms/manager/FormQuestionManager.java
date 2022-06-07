package me.cxis.forms.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.cxis.forms.dao.FormQuestionDao;
import me.cxis.forms.dao.model.FormQuestionDO;
import me.cxis.forms.model.FormQuestionVO;
import me.cxis.forms.model.WidgetRuleVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class FormQuestionManager {

    @Resource
    private FormQuestionDao formQuestionDao;

    public void create(Long formId, List<FormQuestionVO> questions) {
        if (CollectionUtils.isEmpty(questions)) {
            return;
        }

        // 排序
        questions = questions
                .stream()
                .sorted(Comparator.comparing(FormQuestionVO::getOrder))
                .collect(Collectors.toList());

        // 转换
        List<FormQuestionDO> questionDOS = questions
                .stream()
                .map(question -> {
                    question.setFormId(formId);
                    return this.toFormQuestionDO(question);
                })
                .collect(Collectors.toList());
        // 保存
        formQuestionDao.batchSave(questionDOS);
    }


    public List<FormQuestionVO> queryByFormId(Long formId) {
        List<FormQuestionDO> questionDOS = formQuestionDao.selectByFormId(formId);
        if (CollectionUtils.isEmpty(questionDOS)) {
            return null;
        }

        return questionDOS
                .stream()
                .map(this::toFromQuestionVO)
                .collect(Collectors.toList());
    }

    private FormQuestionVO toFromQuestionVO(FormQuestionDO source) {
        if (source == null) {
            return null;
        }

        FormQuestionVO target = new FormQuestionVO();
        target.setId(source.getId());
        target.setFormId(source.getFormId());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setOrder(source.getOrder());
        target.setPageNumber(source.getPageNumber());
        target.setWidgetType(source.getWidgetType());
        target.setWidgetRule(JSONObject.parseObject(source.getWidgetRule(), WidgetRuleVO.class));
        return target;
    }

    private FormQuestionDO toFormQuestionDO(FormQuestionVO source) {
        if (source == null) {
            return null;
        }

        FormQuestionDO target = new FormQuestionDO();
        target.setId(source.getId());
        target.setFormId(source.getFormId());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setOrder(source.getOrder());
        target.setPageNumber(source.getPageNumber());
        target.setWidgetType(source.getWidgetType());
        target.setWidgetRule(JSON.toJSONString(source.getWidgetRule()));
        target.setHidden(source.getHidden());
        target.setJumpRule(JSON.toJSONString(source.getJumpRules()));
        return target;
    }
}
