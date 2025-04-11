package com.bigdata.pattern.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/test")
public class DtoController {

    @GetMapping("/{message}")
    public ResponseEntity<ResponseDto> test(@PathVariable String message) {
        return new ResponseEntity<>(new ResponseDto(200, message, "/test/message"), HttpStatus.OK);
    }
}
