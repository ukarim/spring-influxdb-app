package com.github.ukarim.testapp.service;

import com.github.ukarim.testapp.model.InfluxData;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.influxdb.DefaultInfluxDBTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class InfluxDbService {

    @Autowired
    private DefaultInfluxDBTemplate template;

    @Autowired
    private InfluxDBResultMapper mapper;

    public InfluxData save(InfluxData data) {
        Point point = Point.measurement("test_app")
                .addField("value", data.getValue())
                .build();
        template.write(point);
        return data;
    }

    public Optional<InfluxData> getLast() {

        Query query = new Query("SELECT LAST(value), value FROM test_app", "test_app");
        QueryResult result = template.query(query, TimeUnit.MILLISECONDS);

        List<InfluxData> influxDataList = mapper.toPOJO(result, InfluxData.class);

        return influxDataList.stream().findFirst();
    }

}
