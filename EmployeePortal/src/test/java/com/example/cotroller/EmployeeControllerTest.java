package com.example.cotroller;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.http.MediaType.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import com.example.controller.EmployeeController;
import com.example.model.Employee;
import com.example.service.IEmployeeService;

@SpringBootTest(classes = EmployeeController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IEmployeeService employeeService;

	String empJson = "{\"firstName\": \"Lokesh\",\"gender\": \"Male\",\"dateOfBirth\": \"09/09/1986\",\"department\": \"CSE\",\"lastName\": \"Rahul\"}";

	@Test
	public void registerEmployee() throws Exception {
		Employee emp = new Employee();
		emp.setDateOfBirth("09/09/1986");
		emp.setDepartment("CSE");
		emp.setFirstName("Lokesh");
		emp.setLastName("Rahul");
		emp.setGender("Male");

		Mockito.when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(emp);

		RequestBuilder requestBuilder = post("/api/register").accept(APPLICATION_JSON).content(empJson)
				.contentType(APPLICATION_JSON);

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON))
				.andExpect(jsonPath("$.firstName", is("Lokesh")))
				.andExpect(jsonPath("$.lastName", is("Rahul")))
				.andExpect(jsonPath("$.department", is("CSE")));

	}

	@Test
	public void getAllEmployee() throws Exception {
		

		Employee emp = new Employee();
		emp.setDateOfBirth("09/09/1986");
		emp.setDepartment("CSE");
		emp.setFirstName("Lokesh");
		emp.setLastName("Rahul");
		emp.setGender("Male");
		
		Employee emp2 = new Employee();
		emp2.setDateOfBirth("09/09/1986");
		emp2.setDepartment("CSE");
		emp2.setFirstName("Rishabh");
		emp2.setLastName("Pant");
		emp2.setGender("Male");

		Mockito.when(employeeService.getAllEmployee()).thenReturn(Arrays.asList(emp,emp2));

		RequestBuilder requestBuilder = get("/api/employees");

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content()
				.contentType(APPLICATION_JSON))
				.andExpect(jsonPath("$[0].firstName", is("Lokesh")))
				.andExpect(jsonPath("$[0].lastName", is("Rahul")))
				.andExpect(jsonPath("$[0].department", is("CSE")))
				.andExpect(jsonPath("$[1].firstName", is("Rishabh")))
				.andExpect(jsonPath("$[1].lastName", is("Pant")))
				.andExpect(jsonPath("$[1].department", is("CSE")));

	
}

}
