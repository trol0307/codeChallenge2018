package com.pep.restapi.controller;

import com.pep.restapi.domain.entity.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "UploadExcel", tags = "Read and validates the contact")
@Controller
@RequestMapping("contact")

public class ChallengeController {

    @ApiOperation(value = "Read the contact")
    @RequestMapping(value="/read", method= RequestMethod.GET)
    public ResponseEntity<Object> getContact(@RequestParam("id") Integer contactId) {
        ApiResponse apiResponse = new ApiResponse("pep","trol",200);

        return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(apiResponse.getStatusCode()));
    }
}