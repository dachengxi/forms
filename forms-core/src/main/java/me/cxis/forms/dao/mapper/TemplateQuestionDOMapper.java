package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.TemplateQuestionDO;

public interface TemplateQuestionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TemplateQuestionDO row);

    int insertSelective(TemplateQuestionDO row);

    TemplateQuestionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TemplateQuestionDO row);

    int updateByPrimaryKeyWithBLOBs(TemplateQuestionDO row);

    int updateByPrimaryKey(TemplateQuestionDO row);
}