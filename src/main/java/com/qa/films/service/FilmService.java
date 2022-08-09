package com.qa.films.service;

import java.util.List;

import com.qa.films.domain.Film;

public interface FilmService {
	
	
     String greeting();
		
	
	 Film makeMovie(Film film);

	
	 List<Film> getAllFilms();

	
	 Film getById(int id);
	
	
	 Film updateFilm(int id, String name, Double cost, String genre);
		
	
	 void delete(int id);
	

}
