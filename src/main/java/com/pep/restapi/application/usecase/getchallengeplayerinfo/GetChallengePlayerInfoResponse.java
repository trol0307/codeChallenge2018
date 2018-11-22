package com.pep.restapi.application.usecase.getchallengeplayerinfo;

public class GetChallengePlayerInfoResponse {

    private String name;
    private String eMail;
    private Integer statusCode;


    public GetChallengePlayerInfoResponse(String name, String eMail, Integer statusCode){
        this.name = name;
        this.eMail= eMail;
        this.statusCode = statusCode;
    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

}
