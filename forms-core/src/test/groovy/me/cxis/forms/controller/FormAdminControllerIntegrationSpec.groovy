package me.cxis.forms.controller

import com.alibaba.fastjson.JSONObject
import me.cxis.forms.AbstractIntegrationSpec
import me.cxis.forms.model.FormVO
import spock.lang.Narrative
import spock.lang.Title

import javax.annotation.Resource

@Title("表单管理接口集成测试")
@Narrative("""
    表单管理接口FormAdminController的集成测试
""")
class FormAdminControllerIntegrationSpec extends AbstractIntegrationSpec {

    @Resource
    private FormAdminController formAdminController;

    def "测试save方法" () {
        given: "一个单页模式表单"
        def json = this.getClass().getResource("/mock/单页模式表单.json").text
        def form = JSONObject.parseObject(json, FormVO.class)

        when: "调用保存表单方法"
        def result = formAdminController.save(form)

        then: "期望返回新增的表单ID"
        result
    }
}
