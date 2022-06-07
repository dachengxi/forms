package me.cxis.forms.dao;

import me.cxis.forms.dao.mapper.FormQuestionDOMapper;
import me.cxis.forms.dao.model.FormQuestionDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class FormQuestionDao {

    @Resource
    private FormQuestionDOMapper formQuestionDOMapper;

    public void batchSave(List<FormQuestionDO> questions) {
        LocalDateTime now = LocalDateTime.now();
        questions.forEach(question -> {
            question.setDeleted(false);
            question.setCreateTime(now);
            question.setUpdateTime(now);
        });

        formQuestionDOMapper.insertBatch(questions);
    }

    public List<FormQuestionDO> selectByFormId(Long formId) {
        return formQuestionDOMapper.selectByFormId(formId);
    }
}
