package me.cxis.forms.controller

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.sql.Sql
import me.cxis.forms.AbstractIntegrationSpec

import javax.annotation.Resource
import javax.sql.DataSource

class AnswersToEsIntegrationSpec extends AbstractIntegrationSpec {

    @Resource
    DataSource dataSource

    def "将亚健康问卷的答案生成ES批量插入的Json数据"() {
        expect:
        def jsonSlurper = new JsonSlurper()
        def file = new File('forms_sub_health_answers_es.json')
        def user_id = 100000 as long
        def sql = new Sql(dataSource)
        for (int i = 0; i < 10000; i++) {
            def sql_str = "select * from user_form_answer where user_id = ${user_id} order by id asc"
            def result = sql.rows(sql_str)
            println(i + sql_str)

            def index_id = i + 1
            def index_map = [:]
            index_map['index'] = ['_id': index_id]
            file.append(JsonOutput.toJson(index_map) + '\n')

            def map = [:]
            map['id'] = index_id
            map['user_id'] = user_id
            map['template_id'] = 1 as long
            map['form_id'] = 1 as long
            map['user_form_id'] = result[0].user_form_id as long

            result.each {it -> {
                def single_widget = false
                def widget_type = it.widget_type as int
                if (widget_type in [1, 2, 4, 6]) {
                    single_widget = true
                }

                def question_id = it.question_id as long
                switch (question_id) {
                    case 1:
                        map['gender'] = it.value as String
                        break
                    case 2:
                        map['age'] = it.value as int
                        break
                    case 3:
                        map['height'] = it.value as int
                        break
                    case 4:
                        map['weight'] = it.value as int
                        break
                    case 5:
                        map['work'] = it.value as String
                        break
                    case 7:
                        map['physical_exam'] = it.value as String
                        break
                }

                if (!single_widget) {
                    def value = it.value as String
                    def list = jsonSlurper.parseText(value)
                    def values= []
                    list.each {
                        lit -> {
                            values << lit.value
                        }
                    }
                    switch (question_id) {
                        case 6:
                            map['activity'] = values
                            break
                    }
                }
            }}
            file.append(JsonOutput.toJson(map) + '\n')

            user_id = user_id + 1
        }
    }
}
