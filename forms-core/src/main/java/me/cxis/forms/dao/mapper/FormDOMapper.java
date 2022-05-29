package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.FormDO;

public interface FormDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FormDO row);

    int insertSelective(FormDO row);

    FormDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FormDO row);

    int updateByPrimaryKey(FormDO row);
}