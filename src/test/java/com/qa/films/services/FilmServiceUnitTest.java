package com.qa.films.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.films.domain.Film;
import com.qa.films.repos.FilmRepo;
import com.qa.films.service.FilmService;

@SpringBootTest
//@ActiveProfiles("test")
public class FilmServiceUnitTest {

	@Autowired
	private FilmService service;
	
	@MockBean
	private FilmRepo repo;
	
	@Test
	void testUpdate() {
		
		final int id = 1;
		
		final String name = "Aliens";
		
		final Double newCost = 17.99;
		
		final String newGenre = "Action/Sci-Fi";
		
		Film expected = new Film(id, name, newCost, newGenre);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Film(id, name, newCost, newGenre)));
		Mockito.when(this.repo.save(new Film(id, name, newCost, newGenre))).thenReturn(new Film (id, name, newCost, newGenre));
		Film actual = this.service.updateFilm(id, null, newCost, newGenre);
		
		
		
		assertEquals(expected, actual);
				
	}
}
