package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.UserFormDO;

public interface UserFormDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserFormDO row);

    int insertSelective(UserFormDO row);

    UserFormDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFormDO row);

    int updateByPrimaryKey(UserFormDO row);
}