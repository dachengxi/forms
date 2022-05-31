package me.cxis.forms.manager;

import me.cxis.forms.dao.TemplateDao;
import me.cxis.forms.dao.model.TemplateDO;
import me.cxis.forms.model.TemplateVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class TemplateManager {

    @Resource
    private TemplateDao templateDao;

    public Long create(TemplateVO template) {
        TemplateDO templateDO = toTemplateDO(template);
        templateDO.setCode(UUID.randomUUID().toString().replace("-", ""));
        templateDO.setStatus(1);
        return templateDao.create(templateDO);
    }

    private TemplateDO toTemplateDO(TemplateVO source) {
        if (source == null) {
            return null;
        }

        TemplateDO target = new TemplateDO();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setType(source.getType());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setTotalPage(source.getTotalPage());
        target.setMode(source.getMode());
        return target;
    }
}
