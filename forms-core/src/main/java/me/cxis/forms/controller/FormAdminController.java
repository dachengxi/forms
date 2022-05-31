package me.cxis.forms.controller;

import me.cxis.forms.model.FormVO;
import me.cxis.forms.service.FormService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/form")
public class FormAdminController {

    @Resource
    private FormService formService;

    @PostMapping("/save")
    public Long save(@RequestBody FormVO form) {
        // TODO 参数校验

        return formService.save(form);
    }
}
