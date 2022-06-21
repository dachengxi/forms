package me.cxis.forms.service;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import me.cxis.forms.es.ESClient;
import me.cxis.forms.model.SubHealth;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("formsSearchService")
public class FormsSearchService {

    @Resource
    private ESClient esClient;

    public List<SubHealth> search() throws IOException {
        SearchRequest request = new SearchRequest.Builder()
                .index("forms_sub_health")
                .query(q -> q.term(t -> t.field("age").value(v -> v.longValue(0))))
                .build();
        SearchResponse<SubHealth> search = esClient.getClient().search(request, SubHealth.class);

        List<SubHealth> result = new ArrayList<>();
        for (Hit<SubHealth> hit : search.hits().hits()) {
            result.add(hit.source());
        }

        return result;
    }
}
