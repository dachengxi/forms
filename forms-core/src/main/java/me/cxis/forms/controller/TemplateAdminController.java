package me.cxis.forms.controller;

import me.cxis.forms.model.TemplateVO;
import me.cxis.forms.service.TemplateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/template")
public class TemplateAdminController {

    @Resource
    private TemplateService templateService;

    @PostMapping("/save")
    public Long save(@RequestBody TemplateVO template) {
        // TODO 参数校验

        return templateService.save(template);
    }
}
