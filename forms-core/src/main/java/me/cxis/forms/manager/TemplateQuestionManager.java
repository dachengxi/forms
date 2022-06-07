package me.cxis.forms.manager;

import com.alibaba.fastjson.JSON;
import me.cxis.forms.dao.TemplateQuestionDao;
import me.cxis.forms.dao.model.TemplateQuestionDO;
import me.cxis.forms.model.TemplateQuestionVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class TemplateQuestionManager {

    @Resource
    private TemplateQuestionDao templateQuestionDao;

    public void create(Long templateId, List<TemplateQuestionVO> questions) {
        if (CollectionUtils.isEmpty(questions)) {
            return;
        }

        // 排序
        questions = questions
                .stream()
                .sorted(Comparator.comparing(TemplateQuestionVO::getOrder))
                .collect(Collectors.toList());

        // 转换
        List<TemplateQuestionDO> questionDOS = questions
                .stream()
                .map(question -> {
                    question.setTemplateId(templateId);
                    return this.toTemplateQuestionDO(question);
                })
                .collect(Collectors.toList());
        // 保存
        templateQuestionDao.batchSave(questionDOS);
    }

    private TemplateQuestionDO toTemplateQuestionDO(TemplateQuestionVO source) {
        if (source == null) {
            return null;
        }

        TemplateQuestionDO target = new TemplateQuestionDO();
        target.setId(source.getId());
        target.setTemplateId(source.getTemplateId());
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
