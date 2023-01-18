package tech.tresearchgroup.sao.model;

import com.google.gson.annotations.JsonAdapter;

import java.util.List;

public class GlobalSearchResultEntity {
    private List<ResultEntity> results;


    public GlobalSearchResultEntity(List<ResultEntity> searchResultList) {
        this.results = searchResultList;
    }

    public List<ResultEntity> getSearchResultList() {
        return results;
    }

    public void setResults(List<ResultEntity> results) {
        this.results = results;
    }
}
