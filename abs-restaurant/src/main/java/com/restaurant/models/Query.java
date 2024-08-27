package com.restaurant.models;

public class Query {
    private int queryId;
    private int userId;
    private String message;
    private String status;

    public Query() {
    }

    public Query(int queryId, int userId, String message, String status) {
        this.queryId = queryId;
        this.userId = userId;
        this.message = message;
        this.status = status;
    }

    public Query(int userId, String message, String status) {
        this.userId = userId;
        this.message = message;
        this.status = status;
    }

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
