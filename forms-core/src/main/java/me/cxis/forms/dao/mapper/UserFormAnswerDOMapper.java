package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.UserFormAnswerDO;

public interface UserFormAnswerDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserFormAnswerDO row);

    int insertSelective(UserFormAnswerDO row);

    UserFormAnswerDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFormAnswerDO row);

    int updateByPrimaryKeyWithBLOBs(UserFormAnswerDO row);

    int updateByPrimaryKey(UserFormAnswerDO row);
}