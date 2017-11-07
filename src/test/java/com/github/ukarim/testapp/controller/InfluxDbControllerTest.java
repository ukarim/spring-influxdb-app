package com.github.ukarim.testapp.controller;

import com.github.ukarim.testapp.model.InfluxData;
import com.github.ukarim.testapp.service.InfluxDbService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InfluxDbController.class)
public class InfluxDbControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InfluxDbService service;

    private String requestExample;

    private InfluxData data;

    @Before
    public void setUp() {
        requestExample = "{\"value\": \"100\"}";
        data = new InfluxData();
        data.setValue("100");
    }

    @Test
    public void save() throws Exception {

        given(service.save(data)).willReturn(data);

        mockMvc.perform(
                post("/")
                .content(requestExample)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(status().isCreated())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8));

    }

}