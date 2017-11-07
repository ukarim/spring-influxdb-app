package com.github.ukarim.testapp.controller;

import com.github.ukarim.testapp.model.InfluxData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfluxDbController {

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public ResponseEntity<InfluxData> get() {
        InfluxData data = new InfluxData();
        data.setTime(124554552122L);
        data.setValue("1234");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST
    )
    public ResponseEntity<InfluxData> save(@RequestBody InfluxData data) {
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

}
