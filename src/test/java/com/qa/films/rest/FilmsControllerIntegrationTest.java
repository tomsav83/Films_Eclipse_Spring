package com.qa.films.rest;

import static org.mockito.ArgumentMatchers.anyList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.films.domain.Film;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:film-schema.sql",
		"classpath:film-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD )

@ActiveProfiles("test") // sets profile to "test" so it uses the application-test.properties

public class FilmsControllerIntegrationTest {
	
  @Autowired	
  private MockMvc mvc; // sends test requests
  
  @Autowired	
  private ObjectMapper mapper;
  
//  @BeforeAll
//  void setup () {
//	  
//  }
  
  
  @Test
  void testCreate() throws Exception {
	  Film testFilm = new Film("T2", 12.99, "Action");
	  RequestBuilder req = post("/createFilm").content(this.mapper.writeValueAsString(testFilm))
			  .contentType(org.springframework.http.MediaType.APPLICATION_JSON);
	  
	  ResultMatcher checkStatus = status().isCreated();
	  Film testSavedFilm = new Film(2, "T2", 12.99, "Action");
	  ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedFilm));
	  
	  this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }
  
  @Test
  void testCreateButHardtoRead() throws Exception {
	  this.mvc.perform(
			  post("/createFilm").content(this.mapper.writeValueAsString(new Film("T2", 12.99, "Action")))
			  .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
	  .andExpect(status().isCreated())
	  .andExpect(content().json(this.mapper.writeValueAsString(new Film(2, "T2", 12.99, "Action"))));
  }
  
  @Test
  void testGet() throws Exception {
	  List<Film> films = (List.of(new Film(1, "T3", 15.99, "Rubbish"),
			  new Film(2, "Alien", 18.90, "Horror")));
	  
	  ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(films));
	  this.mvc.perform(get("/getAll")).andExpect(status().isOk()).andExpect(checkBody);
			  
	  
  }
  
  @Test
  void testGetById() throws Exception {
	  ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(new Film(1, "T3", 15.99, "Rubbish")));
	  
	  this.mvc.perform(get("/get/1")).andExpect(status().isOk()).andExpect(checkBody);
  }
  
  @Test 
  void testUpdate() throws Exception {
	  Film testFilm = new Film("T2", 12.99, "Action");
	  RequestBuilder req = post("/update/{id}").content(this.mapper.writeValueAsString(testFilm))
			  .contentType(org.springframework.http.MediaType.APPLICATION_JSON);
	  
	  ResultMatcher checkStatus = status().isOk();
	  Film testSavedFilm = new Film(2, "T2", 12.99, "Action");
	  ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedFilm));
	  
	  this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }
	 

  
//  @Test
//  void testDelete() {
//	  Film testFilm = new Film(2, "T2", 12.99, "Action");
//	  RequestBuilder req = post("/remove/{id}").content(this.mapper.writeValueAsString(testFilm))
//			  .contentType(org.springframework.http.MediaType.APPLICATION_JSON);
//	  
//	  ResultMatcher checkStatus = status().isNotFound();
//	  return matcher(HttpStatus.NOT_FOUND);
//  }
//  
}
