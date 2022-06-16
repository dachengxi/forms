package me.cxis.forms.controller

import com.alibaba.fastjson.JSONObject
import groovy.json.JsonSlurper
import me.cxis.forms.AbstractIntegrationSpec
import me.cxis.forms.model.TemplateVO
import spock.lang.Narrative
import spock.lang.Title

import javax.annotation.Resource

@Title("模板管理接口集成测试")
@Narrative("""
    模板管理接口TemplateAdminController的集成测试
""")
class TemplateAdminControllerIntegrationSpec extends AbstractIntegrationSpec {

    @Resource
    private TemplateAdminController templateAdminController;

    def "测试save方法" () {
        given: "一个单页模式表单模板"
        def json = this.getClass().getResource("/mock/单页模式表单模板.json").text
        def template = JSONObject.parseObject(json, TemplateVO.class)

        when: "调用保存模板方法"
        def result = templateAdminController.save(template)

        then: "期望返回新增的模板ID"
        result
    }

    def "亚健康状况评估表单模板创建" () {
        given: "亚健康状况评估表单模板"
        def json = this.getClass().getResource("/mock/亚健康状况评估表单模板.json").text
        def template = JSONObject.parseObject(json, TemplateVO.class)

        when: "调用保存模板方法"
        def result = templateAdminController.save(template)

        then: "期望返回新增的模板ID"
        result == 1
    }
}
