package me.cxis.forms.controller;

import me.cxis.forms.model.UserFormVO;
import me.cxis.forms.model.param.UserFormSaveParam;
import me.cxis.forms.service.UserFormService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/form")
public class UserFromController {

    @Resource
    private UserFormService userFormService;

    @PostMapping("/save")
    public UserFormVO save(@RequestBody UserFormSaveParam param) {
        // TODO 参数校验
        return userFormService.save(param);
    }
}
