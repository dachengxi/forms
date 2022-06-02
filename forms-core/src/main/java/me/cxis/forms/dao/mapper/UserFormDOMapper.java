package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.UserFormDO;
import org.apache.ibatis.annotations.Param;

public interface UserFormDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserFormDO row);

    int insertSelective(UserFormDO row);

    UserFormDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFormDO row);

    int updateByPrimaryKey(UserFormDO row);

    UserFormDO selectUserForm(@Param("userId") Long userId, @Param("formId") Long formId);
}