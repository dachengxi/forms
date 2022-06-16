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

    def "亚健康状况评估表单数据模拟" () {
        expect:
        def formId = 1 as long
        def userId = 100000 as long
        for (int i = 0; i < 10000; i++) {
            def saveParam = new UserFormSaveParam()
            saveParam.setUserId(userId)
            saveParam.setFormId(formId)

            List<UserFormSaveParam.UserFormAnswerSaveParam> answers = []
            def random = new Random()

            // 第1题，性别
            def answer1 = new UserFormSaveParam.UserFormAnswerSaveParam()
            answer1.questionId = 1
            answer1.value = random.nextInt(2) == 0 ? "male" : "female"
            answers.add(answer1)

            // 第2题，年龄
            def answer2 = new UserFormSaveParam.UserFormAnswerSaveParam()
            answer2.questionId = 2
            answer2.value = random.nextInt(150) as String
            answers.add(answer2)

            // 第3题，身高
            def answer3 = new UserFormSaveParam.UserFormAnswerSaveParam()
            answer3.questionId = 3
            answer3.value = random.nextInt(230) as String
            answers.add(answer3)

            // 第4题，体重
            def answer4 = new UserFormSaveParam.UserFormAnswerSaveParam()
            answer4.questionId = 4
            answer4.value = random.nextInt(500) as String
            answers.add(answer4)

            // 第5题，职业
            def answer5 = new UserFormSaveParam.UserFormAnswerSaveParam()
            answer5.questionId = 5
            def work = ['free', 'student', 'worker', 'other']
            Collections.shuffle(work)
            answer5.value = work.first()
            answers.add(answer5)

            // 第6题，活动
            def answer6 = new UserFormSaveParam.UserFormAnswerSaveParam()
            answer6.questionId = 6

            List<UserFormSaveParam.UserFormAnswerSaveParam.ValueParam> values = []

            def answer6_1 = new UserFormSaveParam.UserFormAnswerSaveParam.ValueParam()
            answer6_1.order = 1
            answer6_1.value = random.nextInt(2) == 0 ? "eat" : ""
            values.add(answer6_1)

            def answer6_2 = new UserFormSaveParam.UserFormAnswerSaveParam.ValueParam()
            answer6_2.order = 2
            answer6_2.value = random.nextInt(2) == 0 ? "sing" : ""
            values.add(answer6_2)

            def answer6_3 = new UserFormSaveParam.UserFormAnswerSaveParam.ValueParam()
            answer6_3.order = 3
            answer6_3.value = random.nextInt(2) == 0 ? "sport" : ""
            values.add(answer6_3)

            def answer6_4 = new UserFormSaveParam.UserFormAnswerSaveParam.ValueParam()
            answer6_4.order = 4
            answer6_4.value = random.nextInt(2) == 0 ? "other" : ""
            values.add(answer6_4)

            answer6.values = values
            answers.add(answer6)

            // 第7题，体检
            def answer7 = new UserFormSaveParam.UserFormAnswerSaveParam()
            answer7.questionId = 7
            answer7.value = random.nextInt(2) == 0 ? "yes" : "no"
            answers.add(answer7)

            saveParam.answers = answers

            def result = userFormController.save(saveParam)

            userId = userId + 1
        }
    }
}
