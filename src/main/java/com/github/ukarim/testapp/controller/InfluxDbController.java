package com.github.ukarim.testapp.controller;

import com.github.ukarim.testapp.model.InfluxData;
import com.github.ukarim.testapp.service.InfluxDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class InfluxDbController {

    @Autowired
    private InfluxDbService service;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public ResponseEntity<InfluxData> get() {
        Optional<InfluxData> last = service.getLast();
        InfluxData data = last.orElse(new InfluxData());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST
    )
    public ResponseEntity<InfluxData> save(@RequestBody InfluxData data) {
        InfluxData save = service.save(data);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

}
