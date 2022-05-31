package me.cxis.forms.dao;

import me.cxis.forms.dao.mapper.FormDOMapper;
import me.cxis.forms.dao.model.FormDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Repository
public class FormDao {

    @Resource
    private FormDOMapper formDOMapper;

    public Long create(FormDO formDO) {
        formDO.setCreateTime(LocalDateTime.now());
        formDO.setUpdateTime(formDO.getCreateTime());
        formDO.setIsDeleted(false);
        formDOMapper.insert(formDO);
        return formDO.getId();
    }
}
