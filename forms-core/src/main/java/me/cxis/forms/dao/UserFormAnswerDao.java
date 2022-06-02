package me.cxis.forms.dao;

import me.cxis.forms.dao.mapper.UserFormAnswerDOMapper;
import me.cxis.forms.dao.model.UserFormAnswerDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserFormAnswerDao {

    @Resource
    private UserFormAnswerDOMapper userFormAnswerDOMapper;

    public List<UserFormAnswerDO> selectByUserFormId(Long userFormId) {
        return userFormAnswerDOMapper.selectByUserFormId(userFormId);
    }

    public void batchSave(List<UserFormAnswerDO> answers) {
        LocalDateTime now = LocalDateTime.now();
        answers.forEach(answer -> {
            answer.setIsDeleted(false);
            answer.setCreateTime(now);
            answer.setUpdateTime(now);
        });

        userFormAnswerDOMapper.insertBatch(answers);
    }
}
