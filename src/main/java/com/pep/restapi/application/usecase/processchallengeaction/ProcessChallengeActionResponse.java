package com.pep.restapi.application.usecase.processchallengeaction;

import com.pep.restapi.domain.entity.GamePost;

public class ProcessChallengeActionResponse {

    private String move;

    public String getMove() {
        return move;
    }

    public ProcessChallengeActionResponse(String move) {
        this.move = move;
    }

}
