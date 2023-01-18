package tech.tresearchgroup.sao.model;

import com.meilisearch.sdk.Index;

import java.util.List;

public interface GenericSearchFunctionality {
    List search(String query, Index index) throws Exception;

    void createDocument(Object object, Index index) throws Exception;

    void updateDocument(Object object, Index index) throws Exception;

    void deleteDocument(long id, Index index) throws Exception;

    void deleteAllDocuments(Index index) throws Exception;

    void reindex(int maxResultsSize, List items, Index index, Class theClass) throws Exception;
}
