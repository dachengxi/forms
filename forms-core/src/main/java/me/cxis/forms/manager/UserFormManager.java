package me.cxis.forms.manager;

import me.cxis.forms.dao.UserFormDao;
import me.cxis.forms.dao.model.UserFormDO;
import me.cxis.forms.model.UserFormVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserFormManager {

    @Resource
    private UserFormDao userFormDao;

    public UserFormVO queryUserForm(Long userId, Long formId) {
        UserFormDO userFormDO = userFormDao.queryUserForm(userId, formId);
        if (userFormDO == null) {
            return null;
        }
        return toUserFormVO(userFormDO);
    }

    public Long save(UserFormVO userForm) {
        UserFormDO userFormDO = toUserFormDO(userForm);
        return userFormDao.save(userFormDO);
    }

    private UserFormDO toUserFormDO(UserFormVO source) {
        if (source == null) {
            return null;
        }

        UserFormDO target = new UserFormDO();
        target.setId(source.getId());
        target.setStatus(source.getStatus());
        target.setFormId(source.getFormId());
        target.setUserId(source.getUserId());
        return target;
    }

    private UserFormVO toUserFormVO(UserFormDO source) {
        if (source == null) {
            return null;
        }

        UserFormVO target = new UserFormVO();
        target.setId(source.getId());
        target.setStatus(source.getStatus());
        target.setFormId(source.getFormId());
        target.setUserId(source.getUserId());
        return target;
    }
}