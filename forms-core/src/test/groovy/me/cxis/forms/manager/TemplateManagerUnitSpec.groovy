package me.cxis.forms.manager

import me.cxis.forms.AbstractUnitSpec
import me.cxis.forms.dao.TemplateDao
import me.cxis.forms.dao.model.TemplateDO
import me.cxis.forms.model.TemplateVO
import spock.lang.Narrative
import spock.lang.Title

@Title("TemplateManager单元测试")
@Narrative("""
    TemplateManager单元测试
""")
class TemplateManagerUnitSpec extends AbstractUnitSpec {

    def "验证create方法的输入参数为null的场景" () {
        given: "一个TemplateManager，输入参数为：null"
        def templateManager = new TemplateManager()
        def template = null

        when: "使用参数null调用create方法"
        templateManager.create(template)

        then: "期望得到一个空指针异常"
        thrown(NullPointerException)
    }

    def "验证正确调用create方法的场景" () {
        given: "一个TemplateManager，一个正确的TemplateVO，一个模拟的TemplateDao"
        def templateManager = new TemplateManager()
        def template = new TemplateVO(title: "test template title")
        def templateDao = Mock(TemplateDao)
        templateManager.templateDao = templateDao

        and: "模拟调用TemplateDao.create返回一个模板ID"
        templateDao.create(_) >> 1

        when: "调用TemplateManager的create方法"
        def result = templateManager.create(template)

        then: "验证返回结果，预期返回的模板ID为1"
        result == 1

        and: "预期调用了TemplateDao.create方法1次，返回的ID为1"
        1 * templateDao.create(_ as TemplateDO) >> 1
    }
}
