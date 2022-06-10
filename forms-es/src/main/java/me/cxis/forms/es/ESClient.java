package me.cxis.forms.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ESClient {

    private RestClient restClient;

    private ElasticsearchTransport transport;

    private ElasticsearchClient client;

    @PostConstruct
    private void init() {
        restClient = RestClient.builder(
                new HttpHost("localhost", 9200)
        ).build();

        transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        client = new ElasticsearchClient(transport);
    }

    public void search() {
        // client.search()
    }
}
