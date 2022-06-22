# 安装、配置、启动ES

本地测试使用docker安装es，命令如下：

```
docker network create elastic
docker pull docker.elastic.co/elasticsearch/elasticsearch:8.2.2
docker run --name es01 --net elastic -p 9200:9200 -p 9300:9300 -it docker.elastic.co/elasticsearch/elasticsearch:8.2.2

```

启动es之后可以在打印的日志中找到用户名、密码、以及在Kibana上使用的enrollment token，找到了之后记下来，后续登录ES以及Kibana使用，如果没记下来可以使用下面的进行重置密码以及重置enrollment token。

重置密码：

```
docker exec -it {elastic_search_container_id} /bin/bash
bin/elasticsearch-reset-password --username elastic -i
```

账号密码：

- elastic/12345678

重置Kibana使用的enrollment token：

```
docker exec -it {elastic_search_container_id} /bin/bash
bin/elasticsearch-create-enrollment-token --scope kibana
```

访问elasticsearch:

- 浏览器直接访问：https://localhost:9200，弹框中输入账号密码
- Chrome上使用ElasticSearch Head插件，地址输入：https://localhost:9200/?auth_user=elastic&auth_password=12345678
- 使用Kibana访问，Kibana --> 左侧主菜单 --> Management --> Dev Tools

由于访问es默认需要使用https，需要从docker中复制http_ca.crt文件到本地，命令如下：

```
docker cp es01:/usr/share/elasticsearch/config/certs/http_ca.crt /目的地址
```

# 安装、配置、启动Kibana

本地测试使用docker安装Kibana，命令如下：

```
docker pull docker.elastic.co/kibana/kibana:8.2.2
docker run --name kibana --net elastic -p 5601:5601 docker.elastic.co/kibana/kibana:8.2.2
```

可以使用如下命令重新获取Verification code：

```
docker exec -it {kibana_container_id} /bin/bash
bin/kibana-verification-code
```

访问Kibana：

- 浏览器：http://localhost:5601/

# 使用

## 索引创建

用途：亚健康问卷索引，索引名称：`forms_sub_health`，mappings定义：

```
PUT /forms_sub_health
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
      "gender": {
        "type": "keyword"
      },
      "age": {
        "type": "integer"
      },
      "height": {
        "type": "integer"
      },
      "weight": {
        "type": "integer"
      },
      "work": {
        "type": "keyword"
      },
      "activity": {
        "type": "text"
      },
      "physical_exam": {
        "type": "keyword"
      }
    }
  }
}
```

## 批量生成测试数据

测试数据生成请使用forms-core的单测生成，具体单测类：AnswersToEsIntegrationSpec，执行生成方法后会在forms-core目录下生成一个数据文件：`forms_sub_health_answers_es.json`

生成数据文件后，使用如下命令导入es中：`curl -k --insecure --user elastic:12345678 -XPOST https://localhost:9200/forms_sub_health/_bulk -H 'Content-Type: application/json' --data-binary @forms_sub_health_answers_es.json`


## 按照性别分组统计

SQL:

```
POST /_sql?format=txt
{
  "query": "select gender, count(1) from forms_sub_health group by gender"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "group_by_gender": {
      "terms": {
        "field": "gender"
      }
    }
  }
}
```

## 按照性别分组统计并排序

SQL:

```
POST /_sql?format=txt
{
  "query": "select gender, count(*) as num from forms_sub_health group by gender order by num desc"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "group_by_gender": {
      "terms": {
        "field": "gender",
        "order": {
          "_count": "desc"
        }
      }
    }
  }
}
```

## 按照年龄分组统计后，对结果进行过滤

SQL:

```
POST /_sql?format=txt
{
  "query": "select gender, count(*) as num from forms_sub_health group by gender having num > 5000"
}
```

可以将SQL转换为DSL：

```
POST /_sql/translate
{
  "query": "select gender, count(*) as num from forms_sub_health group by gender having num > 5000"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "group_by_gender": {
      "terms": {
        "field": "gender"
      },
      "aggs": {
        "bucker_filter": {
          "bucket_selector": {
            "script": "params.count > 5000",
            "buckets_path": {
              "count": "_count"
            }
          }
        }
      }
    }
  }
}
```

## 求平均年龄

SQL:

```
POST /_sql?format=txt
{
  "query": "select avg(age) from forms_sub_health"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "avg_age": {
      "avg": {
        "field": "age"
      }
    }
  }
}
```

## 求不同性别的平均年龄

SQL:

```
POST /_sql?format=txt
{
  "query": "select gender, avg(age) as avg_age from forms_sub_health group by gender"
}
```

DSL: 

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "group_by_gender": {
      "terms": {
        "field": "gender"
      },
      "aggs": {
        "avg_age": {
          "avg": {
            "field": "age"
          }
        }
      }
    }
  }
}
```

## 求部分用户的平均年龄

SQL:

```
POST /_sql?format=txt
{
  "query": "select avg(age) from forms_sub_health where user_id > 106666"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "query": {
    "range": {
      "user_id": {
        "gte": 106666
      }
    }
  },
  "aggs": {
    "avg_age": {
      "avg": {
        "field": "age"
      }
    }
  }
}
```

## 查询最大年龄

SQL:

```
POST /_sql?format=txt
{
  "query": "select max(age) from forms_sub_health"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "max_age": {
      "max": {
        "field": "age"
      }
    }
  }
}
```

## 查询最小年龄

SQL:

```
POST /_sql?format=txt
{
  "query": "select min(age) from forms_sub_health"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "min_age": {
      "min": {
        "field": "age"
      }
    }
  }
}
```

## 求年龄总和

SQL:

```
POST /_sql?format=txt
{
  "query": "select sum(age) from forms_sub_health"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "sum_age": {
      "sum": {
        "field": "age"
      }
    }
  }
}
```

## 统计数量

SQL:

```
POST /_sql?format=txt
{
  "query": "select count(id) from forms_sub_health"
}
```

DSL:

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "count_id": {
      "value_count": {
        "field": "id"
      }
    }
  }
}
```

## stats统计

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "stats_age": {
      "stats": {
        "field": "age"
      }
    }
  }
}
```

## 查询某个用户的数据

```
GET /forms_sub_health/_search
{
  "query": {
    "term": {
      "user_id": {
        "value": "100000"
      }
    }
  }
}
```

## 查询某个年龄段的数据

```
GET /forms_sub_health/_search
{
  "query": {
    "range": {
      "age": {
        "gte": 18,
        "lte": 60
      }
    }
  }
}
```

## 查询年龄大于某个值并且性别是男的数据

```
GET /forms_sub_health/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "range": {
            "age": {
              "gte": 18
            }
          }
        },
        {
          "term": {
            "gender": {
              "value": "male"
            }
          }
        }
      ]
    }
  }
}
```

## 查询年龄大于某个值并且性别是男性，但是身高不为0的数据

```
GET /forms_sub_health/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "range": {
            "age": {
              "gte": 18
            }
          }
        },
        {
          "term": {
            "gender": {
              "value": "male"
            }
          }
        }
      ],
      "must_not": [
        {
          "term": {
            "height": {
              "value": 0
            }
          }
        }
      ]
    }
  }
}
```

## 查询身高大于等于180或者年龄大于18岁的数据

```
GET /forms_sub_health/_search
{
  "query": {
    "bool": {
      "should": [
        {
          "range": {
            "height": {
              "gte": 180
            }
          }
        },
        {
          "range": {
            "age": {
              "gte": 18
            }
          }
        }
      ]
    }
  }
}
```

## filter过滤查询

filter过滤查询不评分，效率高

```
GET /forms_sub_health/_search
{
  "query": {
    "bool": {
      "filter": {
        "term": {
          "gender": {
            "value": "male"
          }
        }
      }
    }
  }
}
```

## 求不同性别中年龄最大的数据-collapse

```
GET /forms_sub_health/_search
{
  "collapse": {
    "field": "gender",
    "inner_hits": {
      "name": "age",
      "size": 1,
      "sort": {
        "age": {
          "order": "asc"
        }
      }
    }
  }
}
```

## 按照从事工作进行分组

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "group_by_work": {
      "terms": {
        "field": "work"
      }
    }
  }
}
```

## 按照从事工作进行分组，并统计每个分组内男女的数量

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "group_by_work": {
      "terms": {
        "field": "work"
      },
      "aggs": {
        "group_by_gender": {
          "terms": {
            "field": "gender"
          }
        }
      }
    }
  }
}
```

## 统计工作是学生的人数

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "count_student": {
      "filter": {
        "term": {
          "work": {
            "value": "student"
          }
        }
      }
    }
  }
}
```

或者：

```
GET /forms_sub_health/_search
{
  "size": 0,
  "query": {
    "bool": {
      "filter": {
        "term": {
          "work": {
            "value": "student"
          }
        }
      }
    }
  }
}
```

## 统计工作是学生的平均年龄

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "avg_age_student": {
      "filter": {
        "term": {
          "work": {
            "value": "student"
          }
        }
      },
      "aggs": {
        "avg_age": {
          "avg": {
            "field": "age"
          }
        }
      }
    }
  }
}
```

## 分别统计职业是自由和学生的人数

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "count_free_student": {
      "filters": {
        "filters": {
          "work_free": {
            "term": {
              "work": {
                "value": "free"
              }
            }
          },
          "work_student": {
            "term": {
              "work": {
                "value": "student"
              }
            }
          }
        }
      }
    }
  }
}
```

## 分别统计职业是自由和学生的人数，以及年龄大于140的人数

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "count_free_student": {
      "filters": {
        "filters": {
          "work_free": {
            "term": {
              "work": {
                "value": "free"
              }
            }
          },
          "work_student": {
            "term": {
              "work": {
                "value": "student"
              }
            }
          },
          "age_gt_140": {
            "range": {
              "age": {
                "gt": 140
              }
            }
          }
        }
      }
    }
  }
}
```

## 将年龄按照0-18，19-100，100-max进行分组

range用from和to来定义区间，是左闭右开。

```
GET /forms_sub_health/_search
{
  "size": 0,
  "aggs": {
    "age_range": {
      "range": {
        "field": "age",
        "ranges": [
          {
            "to": "19"
          },
          {
            "from": "19",
            "to": "101"
          },
          {
            "from": "101"
          }
        ]
      }
    }
  }
}
```

## 按照从事工作进行分组，并获取每个组里面年龄最大的，同时展示每个组里面年龄排前2的人

```
GET /forms_sub_health/_search
{
  "collapse": {
    "field": "work",
    "inner_hits": {
      "name": "age_inner",
      "size": 2,
      "sort": {
        "age": {
          "order": "desc"
        }
      }
    }
  },
  "sort": {
    "age": {
      "order": "desc"
    }
  }
}
```

## 过滤所有男性，并且将过滤后的数据按照从事工作进行分组

先过滤再聚合，该结果中hits中是过滤后的数据：

```
GET /forms_sub_health/_search
{
  "size": 5,
  "query": {
    "bool": {
      "filter": {
        "term": {
          "gender": {
            "value": "male"
          }
        }
      }
    }
  },
  "aggs": {
    "group_by_work": {
      "terms": {
        "field": "work"
      }
    }
  }
}
```

先filter聚合再内嵌terms聚合，该结果中hits是过滤前的数据：

```
GET /forms_sub_health/_search
{
  "size": 5,
  "aggs": {
    "group_of_male": {
      "filter": {
        "term": {
          "gender": {
            "value": "male"
          }
        }
      },
      "aggs": {
        "count_of_work": {
          "terms":{
            "field": "work"
          }
        }
      }
    }
  }
}
```

## 过滤所有男性，并且将过滤后的数据按照从事工作进行分组，并求每个分组的平均年龄

```
GET /forms_sub_health/_search
{
  "size": 5,
  "aggs": {
    "group_of_male": {
      "filter": {
        "term": {
          "gender": {
            "value": "male"
          }
        }
      },
      "aggs": {
        "count_of_work": {
          "terms":{
            "field": "work"
          },
          "aggs": {
            "avg_age": {
              "avg": {
                "field": "age"
              }
            }
          }
        }
      }
    }
  }
}
```

## 过滤所有男性，并且将过滤后的数据按照从事工作进行分组，并求每个分组的平均年龄，并按照平均年龄排序

```
GET /forms_sub_health/_search
{
  "size": 5,
  "aggs": {
    "group_of_male": {
      "filter": {
        "term": {
          "gender": {
            "value": "male"
          }
        }
      },
      "aggs": {
        "count_of_work": {
          "terms":{
            "field": "work",
            "order": {
              "avg_age": "asc"
            }
          },
          "aggs": {
            "avg_age": {
              "avg": {
                "field": "age"
              }
            }
          }
        }
      }
    }
  }
}
```

## 过滤所有男性，并且将过滤后的数据按照从事工作进行分组，并求每个分组的平均年龄，并按照平均年龄排序，并过滤平均年龄大于75的分组的数据

```
GET /forms_sub_health/_search
{
  "size": 5,
  "aggs": {
    "group_of_male": {
      "filter": {
        "term": {
          "gender": {
            "value": "male"
          }
        }
      },
      "aggs": {
        "count_of_work": {
          "terms":{
            "field": "work",
            "order": {
              "avg_age": "asc"
            }
          },
          "aggs": {
            "avg_age": {
              "avg": {
                "field": "age"
              }
            },
            "having_age_gt_75": {
              "bucket_selector": {
                "buckets_path": {
                  "avg_age_param": "avg_age"
                },
                "script": "params.avg_age_param > 75"
              }
            }
          }
        }
      }
    }
  }
}
```

## 过滤所有男性，并且将过滤后的数据按照从事工作进行分组，并过滤每个分组中总数大于1250的数据

```
GET /forms_sub_health/_search
{
  "size": 5,
  "aggs": {
    "group_of_male": {
      "filter": {
        "term": {
          "gender": {
            "value": "male"
          }
        }
      },
      "aggs": {
        "count_of_work": {
          "terms":{
            "field": "work"
          },
          "aggs": {
            "having": {
              "bucket_selector": {
                "script": "params.count_of_group > 1250",
                "buckets_path": {
                  "count_of_group": "_count"
                }
              }
            }
          }
        }
      }
    }
  }
}
```