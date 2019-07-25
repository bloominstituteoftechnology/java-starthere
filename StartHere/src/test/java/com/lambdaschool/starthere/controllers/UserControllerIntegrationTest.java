package com.lambdaschool.starthere.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.starthere.models.Role;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.models.UserRoles;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest
{
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @Before
    public void initialiseRestAssuredMockMcvWebApplicationContext()
    {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }


    @Test
    public void whenMeasuredResponseTime()
    {
        given().when().get("/roles/roles").then().time(lessThan(5000L));
    }

    @Test
    public void listAllUsers()
    {

    }

    @Test
    public void getUser()
    {
    }

    @Test
    public void getCurrentUserName()
    {
    }

    @WithMockUser(roles = "ADMIN")
    @Test
    public void givenPostAUser() throws Exception
    {
        ArrayList<UserRoles> roles = new ArrayList();

        // Normally something like this would work. However, remember that password
        // cannot be written out :-( so I manually build my JSON to send
        // User u1 = new User();
        // u1.setUsername("snoopy");
        // u1.setPasswordNoEncrypt("password");

        // ObjectMapper mapper = new ObjectMapper();
        // String stringU1 = mapper.writeValueAsString(u1);
        // System.out.println(stringU1);

        String stringU1 = "{\"userid\":0,\"username\":\"snoopy\",\"password\":\"password\",\"userRoles\":[],\"quotes\":[],\"authority\":[]}";

        given().contentType("application/json").body(stringU1)
                .when()
                .post("/users/user")
                .then()
                .statusCode(201);
    }

    @Test
    public void updateUser()
    {
    }

    @Test
    public void deleteUserById()
    {
    }
}