package com.pep.restapi.application.usecase.processchallengeaction;

import com.pep.restapi.domain.entity.GamePost;

public class ProcessChallengeActionRequest {

    private GamePost gamePost;

    public ProcessChallengeActionRequest(GamePost gamePost) {
        this.gamePost = gamePost;
    }

    public GamePost processChallengeActionRequest() {
        return gamePost;
    }
}
