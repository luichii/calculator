package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	private final String addEndpoint = "/add";
	private final String susbstractEndpoint = "/substract";

	@Test
	void givenRequestKo_whenCallAddEndpoint_thenResponse500() throws Exception {

		mockMvc.perform(post(addEndpoint + "?numbers="))
				.andExpect(status().is5xxServerError());

	}

	@Test
	void givenRequestOk_whenCallAddEndpoint_thenResponse200() throws Exception {

		mockMvc.perform(post(addEndpoint + "?numbers=1,2"))
				.andExpect(status().isOk());

	}

	@Test
	void givenRequestOk_whenCallSubstractEndpoint_thenResponse200() throws Exception {
		mockMvc.perform(post(susbstractEndpoint + "?numbers=3,2"))
				.andExpect(status().isOk());

	}

	@Test
	void givenRequestOkAndMoreOneNumber_whenCallAddEndpoint_thenResponseContainsAdditionReqiestNumbers() throws Exception {

		MvcResult result = mockMvc.perform(post(addEndpoint + "?numbers=1,2")).andReturn();

		String content = result.getResponse().getContentAsString();
		Assert.assertEquals(content, "3.0");

	}


	@Test
	void givenRequestOkAnOnlyOneNumber_whenCallAddEndpoint_thenResponseContainsRequestNumber() throws Exception {

		MvcResult result = mockMvc.perform(post(addEndpoint + "?numbers=1")).andReturn();

		String content = result.getResponse().getContentAsString();
		Assert.assertEquals(content, "1.0");

	}

	@Test
	void givenRequestOkAndMoreOneNumber_whenCallSubstractEndpoint_thenResponseContainsSubstactionRequestNumbers() throws Exception {

		MvcResult result = mockMvc.perform(post( susbstractEndpoint + "?numbers=3,2")).andReturn();

		String content = result.getResponse().getContentAsString();
		Assert.assertEquals(content, "1.0");

	}

	@Test
	void givenRequestOkAnOnlyOneNumber_whenCallSubstractEndpoint_thenResponseContainsRequestNumber() throws Exception {

		MvcResult result = mockMvc.perform(post(susbstractEndpoint + "?numbers=1")).andReturn();

		String content = result.getResponse().getContentAsString();
		Assert.assertEquals(content, "1.0");

	}

	@Test
	void givenRequestKo_whenCallSubstractEndpoint_thenResponse500() throws Exception {

		mockMvc.perform(post(susbstractEndpoint + "?numbers="))
				.andExpect(status().is5xxServerError());

	}
}
