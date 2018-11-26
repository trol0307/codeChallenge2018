package com.pep.restapi.domain.valueobjects;

public class ApiResponse {

    private String name;
    private String surname;
    private Integer statusCode;

    public ApiResponse(String name, String surname, Integer statusCode) {
        this.name = name;
        this.surname = surname;
        this.statusCode = statusCode;
    }

    public static ApiResponse createResponse(String name, String surname, Integer statusCode) {
        return new ApiResponse(name, surname, statusCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
