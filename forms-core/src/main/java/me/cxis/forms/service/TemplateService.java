package me.cxis.forms.service;

import me.cxis.forms.manager.TemplateManager;
import me.cxis.forms.manager.TemplateQuestionManager;
import me.cxis.forms.model.TemplateQuestionVO;
import me.cxis.forms.model.TemplateVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateService {

    @Resource
    private TemplateManager templateManager;

    @Resource
    private TemplateQuestionManager templateQuestionManager;

    @Transactional
    public Long save(TemplateVO template) {
        if (template.getId() != null) {
            // 更新
            return update(template);
        }

        return create(template);
    }

    @Transactional
    public Long create(TemplateVO template) {
        // 保存模板基本信息
        Long templateId = templateManager.create(template);
        template.setId(templateId);

        // 保存模板问题
        templateQuestionManager.create(templateId, template.getQuestions());
        return templateId;
    }

    public Long update(TemplateVO template) {
        return null;
    }
}
