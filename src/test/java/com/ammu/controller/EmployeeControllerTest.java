package com.ammu.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ammu.model.Employee;
import com.ammu.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
	
	private MockMvc mockMvc;
	
	private JacksonTester<Employee> jsonTester;
	
	@Mock
	EmployeeService empServ;
	@InjectMocks
	private EmployeeController employeeController;
	
//	private Employee employee;
//	private List<Employee> employeeList;
	
	
	@BeforeEach
	void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	public void givenEmployeeToSaveThenShouldReturnSavedEmployee() throws Exception {
		String jsonContent = readFileAsString("src/test/resources/TestEmployeeData.JSON");
		Employee employee = jsonTester.parseObject(jsonContent);
		System.out.println(employee);
		
		when(empServ.addAnEmployee(employee)).thenReturn(employee);
        mockMvc.perform(post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
        verify(empServ).addAnEmployee(employee);
		
		
		
	}
	
	private String readFileAsString(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        return new String(bytes, StandardCharsets.UTF_8);
    }
	
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
