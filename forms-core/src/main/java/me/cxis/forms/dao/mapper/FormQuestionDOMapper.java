package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.FormQuestionDO;

import java.util.List;

public interface FormQuestionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FormQuestionDO row);

    int insertSelective(FormQuestionDO row);

    FormQuestionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FormQuestionDO row);

    int updateByPrimaryKey(FormQuestionDO row);

    void insertBatch(List<FormQuestionDO> questions);

    List<FormQuestionDO> selectByFormId(Long formId);
}