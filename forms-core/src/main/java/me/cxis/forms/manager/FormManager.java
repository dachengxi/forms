package me.cxis.forms.manager;

import me.cxis.forms.dao.FormDao;
import me.cxis.forms.dao.model.FormDO;
import me.cxis.forms.model.FormVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class FormManager {

    @Resource
    private FormDao formDao;

    public Long create(FormVO form) {
        FormDO formDO = toTemplateDO(form);
        formDO.setCode(UUID.randomUUID().toString().replace("-", ""));
        formDO.setStatus(1);
        formDO.setVersion(1L);
        return formDao.create(formDO);
    }

    private FormDO toTemplateDO(FormVO source) {
        if (source == null) {
            return null;
        }

        FormDO target = new FormDO();
        target.setId(source.getId());
        target.setTemplateId(source.getTemplateId());
        target.setCode(source.getCode());
        target.setType(source.getType());
        target.setVersion(source.getVersion());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setTotalPage(source.getTotalPage());
        target.setMode(source.getMode());
        return target;
    }
}
