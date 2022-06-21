package me.cxis.forms.service

import me.cxis.forms.AbstractIntegrationSpec

import javax.annotation.Resource

class FormsSearchServiceIntegrationSpec extends AbstractIntegrationSpec {

    @Resource
    FormsSearchService formsSearchService

    def "测试search方法"() {
        expect:
        def result = formsSearchService.search()
        println(result)
        result
    }
}
