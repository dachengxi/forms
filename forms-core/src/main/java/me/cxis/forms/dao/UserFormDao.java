package me.cxis.forms.dao;

import me.cxis.forms.dao.mapper.UserFormDOMapper;
import me.cxis.forms.dao.model.UserFormDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Repository
public class UserFormDao {

    @Resource
    private UserFormDOMapper userFormDOMapper;


    public UserFormDO queryUserForm(Long userId, Long formId) {
        return userFormDOMapper.selectUserForm(userId, formId);
    }

    public Long save(UserFormDO userForm) {
        userForm.setCreateTime(LocalDateTime.now());
        userForm.setUpdateTime(userForm.getCreateTime());
        userForm.setIsDeleted(false);
        userFormDOMapper.insert(userForm);
        return userForm.getId();
    }
}
