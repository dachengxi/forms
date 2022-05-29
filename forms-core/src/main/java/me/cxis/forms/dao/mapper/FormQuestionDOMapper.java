package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.FormQuestionDO;

public interface FormQuestionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FormQuestionDO row);

    int insertSelective(FormQuestionDO row);

    FormQuestionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FormQuestionDO row);

    int updateByPrimaryKeyWithBLOBs(FormQuestionDO row);

    int updateByPrimaryKey(FormQuestionDO row);
}