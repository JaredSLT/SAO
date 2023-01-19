package tech.tresearchgroup.sao.controller;

import com.google.gson.Gson;
import com.meilisearch.sdk.Index;
import com.meilisearch.sdk.SearchRequest;
import com.meilisearch.sdk.model.SearchResult;
import com.meilisearch.sdk.model.Task;
import com.meilisearch.sdk.model.TaskInfo;
import tech.tresearchgroup.sao.model.GenericSearchFunctionality;

import java.util.Arrays;
import java.util.List;

public class GenericSAO implements GenericSearchFunctionality {
    private final Gson gson;

    public GenericSAO(Gson gson) {
        this.gson = gson;
    }

    @Override
    public List search(String query, Index index) throws Exception {
        SearchRequest searchRequest = new SearchRequest().setQ(query);
        SearchResult queryData = index.search(searchRequest);
        Object[] data = queryData.getHits().toArray();
        return Arrays.asList(data);
    }

    @Override
    public void createDocument(Object object, Index index) throws Exception {
        index.addDocuments(gson.toJson(object));
    }

    @Override
    public void updateDocument(Object object, Index index) throws Exception {
        index.updateDocuments(gson.toJson(object));
    }

    @Override
    public void deleteDocument(long id, Index index) throws Exception {
        index.deleteDocument(String.valueOf(id));
    }

    @Override
    public void deleteAllDocuments(Index index) throws Exception {
        TaskInfo task = index.deleteAllDocuments();
        task.wait();
    }

    @Override
    public void reindex(int maxResultsSize, List items, Index index, Class theClass) throws Exception {
        for (Object item : items) {
            String json = gson.toJson(item);
            index.addDocuments(json);
        }
    }
}
