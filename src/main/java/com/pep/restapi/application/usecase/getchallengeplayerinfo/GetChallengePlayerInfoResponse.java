package com.pep.restapi.application.usecase.getchallengeplayerinfo;

public class GetChallengePlayerInfoResponse {

    private String name;
    private String email;
    private Integer statusCode;


    public GetChallengePlayerInfoResponse(String name, String email, Integer statusCode){
        this.name = name;
        this.email= email;
        this.statusCode = statusCode;
    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return email;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

}
