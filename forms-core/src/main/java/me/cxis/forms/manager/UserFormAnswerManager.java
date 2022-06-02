package me.cxis.forms.manager;

import me.cxis.forms.dao.UserFormAnswerDao;
import me.cxis.forms.dao.model.UserFormAnswerDO;
import me.cxis.forms.model.UserFormAnswerVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserFormAnswerManager {

    @Resource
    private UserFormAnswerDao userFormAnswerDao;

    public List<UserFormAnswerVO> queryByUserFormId(Long userFormId) {
        List<UserFormAnswerDO> answerDOS = userFormAnswerDao.selectByUserFormId(userFormId);
        if (CollectionUtils.isEmpty(answerDOS)) {
            return null;
        }
        return answerDOS
                .stream()
                .map(this::toUserFormAnswerVO)
                .collect(Collectors.toList());
    }


    public void save(List<UserFormAnswerVO> answers) {
        List<UserFormAnswerDO> answerDOS = answers
                .stream()
                .map(this::toUserFOrmAnswerDO)
                .collect(Collectors.toList());

        userFormAnswerDao.batchSave(answerDOS);
    }

    private UserFormAnswerDO toUserFOrmAnswerDO(UserFormAnswerVO source) {
        if (source == null) {
            return null;
        }

        UserFormAnswerDO target = new UserFormAnswerDO();
        target.setId(source.getId());
        target.setUserId(source.getUserId());
        target.setUserFormId(source.getUserFormId());
        target.setQuestionId(source.getQuestionId());
        target.setWidgetType(source.getWidgetType());
        target.setValue(source.getValue());
        return target;
    }

    private UserFormAnswerVO toUserFormAnswerVO(UserFormAnswerDO source) {
        if (source == null) {
            return null;
        }

        UserFormAnswerVO target = new UserFormAnswerVO();
        target.setId(source.getId());
        target.setUserId(source.getUserId());
        target.setUserFormId(source.getUserFormId());
        target.setQuestionId(source.getQuestionId());
        target.setWidgetType(source.getWidgetType());
        target.setValue(source.getValue());
        return target;
    }
}
