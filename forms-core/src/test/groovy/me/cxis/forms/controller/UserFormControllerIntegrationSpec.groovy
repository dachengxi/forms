package me.cxis.forms.controller

import com.alibaba.fastjson.JSONObject
import me.cxis.forms.AbstractIntegrationSpec
import me.cxis.forms.model.TemplateVO
import me.cxis.forms.model.param.UserFormSaveParam
import spock.lang.Narrative
import spock.lang.Title

import javax.annotation.Resource

@Title("用户表单接口集成测试")
@Narrative("""
    用户表单接口UserFormController的集成测试
""")
class UserFormControllerIntegrationSpec extends AbstractIntegrationSpec {

    @Resource
    private UserFormController userFormController;

    def "测试save方法" () {
        given: "一个正确的用户表单和答案"
        def json = this.getClass().getResource("/mock/正确的用户表单保存数据.json").text
        def saveParam = JSONObject.parseObject(json, UserFormSaveParam.class)

        when: "调用保存用户表单方法"
        def result = userFormController.save(saveParam)

        then: "期望返回新增的用户表单ID"
        result
        result.id
    }
}
