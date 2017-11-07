package com.github.ukarim.testapp.model;

import lombok.Data;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Data
@Measurement(name = "test_app")
public class InfluxData {

    @Column(name = "time")
    private long time;

    @Column(name = "value")
    private String value;

}
