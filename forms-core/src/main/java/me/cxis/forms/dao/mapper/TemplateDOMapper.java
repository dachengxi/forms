package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.TemplateDO;

public interface TemplateDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TemplateDO row);

    int insertSelective(TemplateDO row);

    TemplateDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TemplateDO row);

    int updateByPrimaryKey(TemplateDO row);
}