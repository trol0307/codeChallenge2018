package com.pep.restapi.application.usecase.processchallengeaction;

import com.pep.restapi.application.usecase.UseCase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProcessChallengeActionUseCase implements UseCase<ProcessChallengeActionRequest,ProcessChallengeActionResponse>{

    public ProcessChallengeActionResponse execute(ProcessChallengeActionRequest request){

        Random rand = new Random();

        Integer randomNumber = rand.nextInt(7)+1;

        List<String> actions = new ArrayList();

        actions.add("left");
        actions.add("right");
        actions.add("up");
        actions.add("down");
        actions.add("fire-up");
        actions.add("fire-down");
        actions.add("fire-right");
        actions.add("fire-left");

        ProcessChallengeActionResponse reponse = new ProcessChallengeActionResponse(actions.get(randomNumber));

        return reponse;


    }
}
