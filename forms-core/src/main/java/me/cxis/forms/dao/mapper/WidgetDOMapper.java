package me.cxis.forms.dao.mapper;

import me.cxis.forms.dao.model.WidgetDO;

public interface WidgetDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WidgetDO row);

    int insertSelective(WidgetDO row);

    WidgetDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WidgetDO row);

    int updateByPrimaryKeyWithBLOBs(WidgetDO row);

    int updateByPrimaryKey(WidgetDO row);
}