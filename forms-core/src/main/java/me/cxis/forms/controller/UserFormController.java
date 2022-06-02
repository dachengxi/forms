package me.cxis.forms.controller;

import me.cxis.forms.model.UserFormVO;
import me.cxis.forms.model.param.UserFormSaveParam;
import me.cxis.forms.service.UserFormService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/form")
public class UserFormController {

    @Resource
    private UserFormService userFormService;

    @PostMapping("/save")
    public UserFormVO save(@RequestBody UserFormSaveParam param) {
        // TODO 参数校验
        return userFormService.save(param);
    }

    @GetMapping("/query")
    public UserFormVO query(@RequestParam Long userId, @RequestParam Long formId) {
        // TODO 参数校验
        return userFormService.query(userId, formId);
    }
}
