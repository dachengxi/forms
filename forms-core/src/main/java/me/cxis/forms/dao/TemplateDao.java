package me.cxis.forms.dao;

import me.cxis.forms.dao.mapper.TemplateDOMapper;
import me.cxis.forms.dao.model.TemplateDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Repository
public class TemplateDao {

    @Resource
    private TemplateDOMapper templateDOMapper;

    public Long create(TemplateDO template) {
        template.setCreateTime(LocalDateTime.now());
        template.setUpdateTime(template.getCreateTime());
        template.setIsDeleted(false);
        templateDOMapper.insert(template);
        return template.getId();
    }
}
