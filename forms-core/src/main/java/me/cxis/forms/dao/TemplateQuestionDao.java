package me.cxis.forms.dao;

import me.cxis.forms.dao.mapper.TemplateQuestionDOMapper;
import me.cxis.forms.dao.model.TemplateQuestionDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TemplateQuestionDao {

    @Resource
    private TemplateQuestionDOMapper templateQuestionDOMapper;

    public void batchSave(List<TemplateQuestionDO> questions) {
        LocalDateTime now = LocalDateTime.now();
        questions.forEach(question -> {
            question.setDeleted(false);
            question.setCreateTime(now);
            question.setUpdateTime(now);
        });

        templateQuestionDOMapper.insertBatch(questions);
    }
}
