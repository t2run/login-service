package com.example.rest.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.rest.model.UserInfo;
import com.example.rest.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@WebMvcTest
class MyRestControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UserService userService;
    
    private UserInfo user;
    
    @InjectMocks
    private MyRestController myRestController;
    
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(myRestController).build();

        user = new UserInfo();
        user.setId(1);
        user.setFirstName("arun");
        user.setLastName("n");
        user.setPassword("pass");
        user.setRole("admin");
        user.setTime(new Date());
    }

	/*
	 * @Test void testMyRestController() { fail("Not yet implemented"); }
	 * 
	 * @Test void testLogin2() { fail("Not yet implemented"); }
	 * 
	 * @Test void testLogin() { fail("Not yet implemented"); }
	 * 
	 * @Test void testLogin3() { fail("Not yet implemented"); }
	 */

	@Test
	void testLogin4()  throws Exception{
        String userId = "arun";
        String password = "pass";

       // Mockito.when(userService.saveUser(user)).thenReturn(true);
        Mockito.when(userService.findByUserNamePass(userId, password)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/v4/login/").contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    // Parsing String format data into JSON format
    private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            result = jsonContent;
        } catch (JsonProcessingException e) {
            result = "Json processing error";
        }
        return result;
    }

	/*
	 * @Test void testGetToken() { fail("Not yet implemented"); }
	 */

}
