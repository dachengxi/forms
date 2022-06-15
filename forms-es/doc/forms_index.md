# 索引创建

索引名称：`forms`，mappings定义：

```
PUT /forms
{
  "mappings": {
    "properties": {
      "id": {
        "type": "long"
      },
      "user_id": {
        "type": "long"
      },
      "template_id": {
        "type": "long"
      },
      "form_id": {
        "type": "long"
      },
      "user_form_id": {
        "type": "long"
      },
      "question_id": {
        "type": "long"
      },
      "answer_id": {
        "type": "long"
      },
      "single_widget": {
        "type": "boolean"
      },
      "answers": {
        "type": "nested"
      }
    }
  }
}
```

# 测试数据

```
PUT /forms/_doc/1
{
  "id": 1,
  "user_id": 1000000,
  "template_id": 1,
  "form_id": 1,
  "user_form_id": 1,
  "question_id": 1,
  "answer_id": 1,
  "single_widget": true,
  "answers": {
    "value": "Jack"
  }
}

PUT /forms/_doc/2
{
  "id": 2,
  "user_id": 1000000,
  "template_id": 1,
  "form_id": 1,
  "user_form_id": 1,
  "question_id": 2,
  "answer_id": 2,
  "single_widget": true,
  "answers": {
    "value": "Jack\nMan"
  }
}

PUT /forms/_doc/3
{
  "id": 3,
  "user_id": 1000000,
  "template_id": 1,
  "form_id": 1,
  "user_form_id": 1,
  "question_id": 3,
  "answer_id": 3,
  "single_widget": false,
  "answers": {
    "values": [
        {
          "value": "111"
        },
        {
          "value": "121"
        }
      ]
  }
}

PUT /forms/_doc/4
{
  "id": 4,
  "user_id": 1000000,
  "template_id": 1,
  "form_id": 1,
  "user_form_id": 1,
  "question_id": 4,
  "answer_id": 4,
  "single_widget": true,
  "answers": {
    "value": "男"
  }
}

PUT /forms/_doc/5
{
  "id": 5,
  "user_id": 1000000,
  "template_id": 1,
  "form_id": 1,
  "user_form_id": 1,
  "question_id": 5,
  "answer_id": 5,
  "single_widget": false,
  "answers": {
    "values": [
        {
          "value": ""
        },
        {
          "value": "B"
        },
        {
          "value": ""
        }
      ]
  }
}
```