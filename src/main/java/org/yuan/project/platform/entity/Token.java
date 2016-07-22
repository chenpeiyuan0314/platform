package org.yuan.project.platform.entity;

public class Token {
    private Integer id;

    private Integer clientId;

    private String code;

    private String createDate;

    private String abadeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAbadeDate() {
        return abadeDate;
    }

    public void setAbadeDate(String abadeDate) {
        this.abadeDate = abadeDate;
    }
}