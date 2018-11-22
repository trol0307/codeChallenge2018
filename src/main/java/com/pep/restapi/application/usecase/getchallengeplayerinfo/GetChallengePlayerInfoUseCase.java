package com.pep.restapi.application.usecase.getchallengeplayerinfo;

import com.pep.restapi.application.usecase.UseCase;
import org.springframework.stereotype.Component;

@Component
public class GetChallengePlayerInfoUseCase implements UseCase<GetChallengePlayerInfoRequest,GetChallengePlayerInfoResponse>{

    public GetChallengePlayerInfoResponse execute(GetChallengePlayerInfoRequest request){

        return new GetChallengePlayerInfoResponse("Pep","trol0307@gmail.com",200);

    }
}
