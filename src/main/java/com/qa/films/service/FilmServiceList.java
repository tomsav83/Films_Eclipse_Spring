package com.qa.films.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.films.domain.Film;

@Service
public class FilmServiceList implements FilmService{
	
	private List<Film> films;
	
	public FilmServiceList() {		
		super();
		this.films = new ArrayList<>();
		this.films.add(new Film("LOTR", 15.50, "Fantasy"));
	}


	@Override
	public Film makeMovie(Film film) {
		this.films.add(film);
		return films.get(this.films.size() -1);
		
	}

	@Override
	public List<Film> getAllFilms() {
		return this.films;
	}

	@Override
	public Film getById(int id) {
		return this.films.get(id);

	}

	@Override
	public Film updateFilm(int id, String name, Double cost, String genre) {
		Film toUpdate = this.films.get(id);
		if (name != null && name.isBlank()) toUpdate.setName(name);
		if (cost != null) toUpdate.setCost(cost);
		if (genre != null && genre.isBlank()) toUpdate.setGenre(genre);
		
		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.films.remove(id);
		
	}


}
