package me.cxis.forms.service;

import me.cxis.forms.manager.TemplateManager;
import me.cxis.forms.model.TemplateQuestionVO;
import me.cxis.forms.model.TemplateVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateService {

    @Resource
    private TemplateManager templateManager;

    public Long save(TemplateVO template) {
        if (CollectionUtils.isEmpty(template.getQuestions())) {
            // TODO 异常
            return null;
        }

        // 校验每个问题
        validateQuestions(template.getQuestions());
        return null;
    }

    private void validateQuestions(List<TemplateQuestionVO> questions) {

    }
}
