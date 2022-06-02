package me.cxis.forms.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import me.cxis.forms.enums.WidgetType;
import me.cxis.forms.manager.UserFormAnswerManager;
import me.cxis.forms.manager.UserFormManager;
import me.cxis.forms.model.FormQuestionVO;
import me.cxis.forms.model.FormVO;
import me.cxis.forms.model.UserFormAnswerVO;
import me.cxis.forms.model.UserFormVO;
import me.cxis.forms.model.param.UserFormSaveParam;
import me.cxis.forms.widgets.Widget;
import me.cxis.forms.widgets.WidgetSelector;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserFormService {

    @Resource
    private FormService formService;

    @Resource
    private UserFormManager userFormManager;

    @Resource
    private UserFormAnswerManager userFormAnswerManager;

    @Resource
    private WidgetSelector widgetSelector;

    @Transactional
    public UserFormVO save(UserFormSaveParam param) {
        // 查询表单和表单问题
        FormVO form = formService.queryById(param.getFormId());
        if (form == null) {
            return null;
        }

        // 转换
        List<UserFormAnswerVO> answers = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(param.getAnswers())) {
            param.getAnswers().forEach(answer -> {
                UserFormAnswerVO answerVO = new UserFormAnswerVO();
                answerVO.setUserId(param.getUserId());
                answerVO.setUserFormId(param.getUserFormId());
                answerVO.setValue(answer.getValue());
                answerVO.setQuestionId(answer.getQuestionId());
                List<UserFormSaveParam.UserFormAnswerSaveParam.ValueParam> valueParams = answer.getValues();
                if (CollectionUtils.isNotEmpty(valueParams)) {
                    List<UserFormAnswerVO.ValuesVO> values = valueParams
                            .stream()
                            .map(valueParam -> {
                                UserFormAnswerVO.ValuesVO valuesVO = new UserFormAnswerVO.ValuesVO();
                                valuesVO.setValue(valueParam.getValue());
                                valuesVO.setOrder(valueParam.getOrder());
                                return valuesVO;
                            })
                            .collect(Collectors.toList());
                    answerVO.setValues(values);
                }

                answers.add(answerVO);
            });
        }

        // 查询用户表单
        UserFormVO userForm = userFormManager.queryUserForm(param.getUserId(), param.getFormId());
        if (userForm == null) {
            // 新增
            if (CollectionUtils.isNotEmpty(answers)) {
                // 表单问题
                List<FormQuestionVO> questions = form.getQuestions();
                Map<Long, FormQuestionVO> questionMapping = new HashMap<>();
                for (FormQuestionVO question : questions) {
                    Long questionId = question.getId();
                    questionMapping.putIfAbsent(questionId, question);
                }

                // 校验答案
                for (UserFormAnswerVO answer : answers) {
                    FormQuestionVO question = questionMapping.get(answer.getQuestionId());
                    answer.setQuestionId(question.getId());
                    answer.setWidgetType(question.getWidgetType());
                    Widget widget = widgetSelector.select(question.getWidgetType());
                    if (widget != null) {
                        widget.validate(answer, question.getWidgetRule());
                    }

                    WidgetType widgetType = WidgetType.of(question.getWidgetType());
                    if (widget != null && widgetType.isMultiValues()) {
                        answer.setValue(JSON.toJSONString(answer.getValues()));
                        answer.setValues(null);
                    }
                }
            }

            // 保存用户表单
            userForm = new UserFormVO();
            userForm.setUserId(param.getUserId());
            userForm.setStatus(1);
            userForm.setFormId(form.getId());
            Long userFormId = userFormManager.save(userForm);

            // 保存用户表单答案
            if (userFormId != null && CollectionUtils.isNotEmpty(answers)) {
                answers.forEach(answer -> {
                    answer.setUserFormId(userFormId);
                    answer.setUserId(param.getUserId());
                });
                userFormAnswerManager.save(answers);
            }
            userForm.setId(userFormId);
            return userForm;
        } else {
            // 更新
        }

        return null;
    }

    public UserFormVO query(Long userId, Long formId) {
        // 查询表单和表单问题
        FormVO form = formService.queryById(formId);
        if (form == null) {
            return null;
        }

        // 查询用户表单
        UserFormVO userForm = userFormManager.queryUserForm(userId, formId);
        if (userForm == null) {
            userForm = new UserFormVO();
        }

        userForm.setQuestions(form.getQuestions());
        userForm.setFormId(form.getId());
        userForm.setFormCode(form.getCode());
        userForm.setFormVersion(form.getVersion());
        userForm.setFormType(form.getType());
        userForm.setFormTitle(form.getTitle());
        userForm.setFormDescription(form.getDescription());
        userForm.setTotalPage(form.getTotalPage());
        userForm.setFormMode(form.getMode());
        userForm.setCurrentPage(null);

        // 查询用户表单答案
        if (userForm.getId() != null) {
            List<UserFormAnswerVO> answers = userFormAnswerManager.queryByUserFormId(userForm.getId());
            // 需要根据组件类型来解析答案的内容
            if (CollectionUtils.isNotEmpty(answers)) {
                answers.forEach(answer -> {
                    WidgetType widgetType = WidgetType.of(answer.getWidgetType());
                    if (widgetType != null && widgetType.isMultiValues()) {
                        answer.setValues(JSONObject.parseArray(answer.getValue(), UserFormAnswerVO.ValuesVO.class));
                        answer.setValue(null);
                    }
                });
            }
            userForm.setAnswers(answers);
        }

        return userForm;
    }
}
