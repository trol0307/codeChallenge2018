package com.pep.restapi.controller;

import com.pep.restapi.application.usecase.getchallengeplayerinfo.GetChallengePlayerInfoRequest;
import com.pep.restapi.application.usecase.getchallengeplayerinfo.GetChallengePlayerInfoResponse;
import com.pep.restapi.application.usecase.getchallengeplayerinfo.GetChallengePlayerInfoUseCase;
import com.pep.restapi.application.usecase.processchallengeaction.ProcessChallengeActionRequest;
import com.pep.restapi.application.usecase.processchallengeaction.ProcessChallengeActionResponse;
import com.pep.restapi.application.usecase.processchallengeaction.ProcessChallengeActionUseCase;
import com.pep.restapi.domain.valueobjects.GamePost;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api(value = "UploadExcel", tags = "Read and validates the contact")
@Controller
@RequestMapping("")

public class ChallengeController {

    private GetChallengePlayerInfoUseCase nameUsecase;

    private ProcessChallengeActionUseCase actionUseCase;




    @Autowired
    public ChallengeController(GetChallengePlayerInfoUseCase nameUsecase, ProcessChallengeActionUseCase actionUseCase){
        this.nameUsecase = nameUsecase;
        this.actionUseCase = actionUseCase;
    }

    @ApiOperation(value = "Player information")
    @RequestMapping(value="/name", method= RequestMethod.POST)
    public ResponseEntity<Object> getPlayerInformation() {
        GetChallengePlayerInfoRequest request = new GetChallengePlayerInfoRequest();
        GetChallengePlayerInfoResponse response = nameUsecase.execute(request);
        return new ResponseEntity<>(response, HttpStatus.valueOf(200));
    }

    @ApiOperation(value = "Next action")
    @RequestMapping(value="/move", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getAction(@RequestBody GamePost gamePostJson) {
        ProcessChallengeActionRequest request = new ProcessChallengeActionRequest(gamePostJson);
        ProcessChallengeActionResponse response = actionUseCase.execute(request);
        return new ResponseEntity<>(response, HttpStatus.valueOf(200));
    }
}