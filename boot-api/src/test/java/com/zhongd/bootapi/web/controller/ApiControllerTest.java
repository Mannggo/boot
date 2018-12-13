package com.zhongd.bootapi.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhongd.bootapi.BootApiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author 谢仲东 2018-12-05 15:22
 */
@SpringBootTest(classes = BootApiApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ApiControllerTest {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApiPost() throws Exception {
        HashMap<String, Object> param = new HashMap<>();
        param.put("text", "12388");
        param.put("sign", "668qq");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/save")
                .content(gson.toJson(param))
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print());
    }
}
