package me.cxis.forms.service;

import me.cxis.forms.manager.FormManager;
import me.cxis.forms.manager.FormQuestionManager;
import me.cxis.forms.model.FormQuestionVO;
import me.cxis.forms.model.FormVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FormService {

    @Resource
    private FormManager formManager;

    @Resource
    private FormQuestionManager formQuestionManager;

    @Transactional
    public Long save(FormVO form) {
        if (form.getId() != null) {
            // 更新
            return update(form);
        }

        return create(form);
    }

    @Transactional
    public Long create(FormVO form) {
        // 保存表单基本信息
        Long formId = formManager.create(form);
        form.setId(formId);

        // 保存表单问题
        formQuestionManager.create(formId, form.getQuestions());
        return formId;
    }

    public Long update(FormVO form) {
        return null;
    }

    public FormVO queryById(Long formId) {
        // 查询表单
        FormVO form = formManager.queryById(formId);

        // 查询表单问题
        List<FormQuestionVO> questions = formQuestionManager.queryByFormId(formId);
        form.setQuestions(questions);
        return form;
    }
}
