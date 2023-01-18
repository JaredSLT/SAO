package tech.tresearchgroup.sao.model;

import com.google.gson.annotations.JsonAdapter;

import java.util.List;

public class ResultEntity {
    private String name;
    private List list;
    public ResultEntity(String objectClassName, List objectList) {
        this.name = objectClassName;
        this.list = objectList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
