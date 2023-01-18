package tech.tresearchgroup.sao.model;

import java.util.List;

public interface SearchFunctionality {
    List search(String query);

    void createDocument(Object object);

    void updateDocument(Object object);

    void deleteDocument(long id);

    void deleteAllDocuments();

    void reindex(int maxResultsSize);
}
