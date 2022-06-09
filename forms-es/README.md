# 启动ES

```
docker network create elastic
docker pull docker.elastic.co/elasticsearch/elasticsearch:8.2.2
docker run --name es01 --net elastic -p 9200:9200 -p 9300:9300 -it docker.elastic.co/elasticsearch/elasticsearch:8.2.2

```

重置密码：

```
docker exec -it {elastic_search_container_id} /bin/bash
bin/elasticsearch-reset-password --username elastic -i
```
帐号密码：
- elastic/12345678

重置Kibana的enrollment token：

```
docker exec -it {elastic_search_container_id} /bin/bash
bin/elasticsearch-create-enrollment-token --scope kibana
```

获取Verification code：

```
docker exec -it {kibana_container_id} /bin/bash
bin/kibana-verification-code
```

## 启动Kibana

```
docker pull docker.elastic.co/kibana/kibana:8.2.2
docker run --name kibana --net elastic -p 5601:5601 docker.elastic.co/kibana/kibana:8.2.2
```
