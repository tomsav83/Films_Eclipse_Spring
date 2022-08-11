package com.qa.films.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.films.domain.Film;
import com.qa.films.repos.FilmRepo;

@Service
@Primary
public class FilmServiceDB implements FilmService {

	private FilmRepo repo;

	public FilmServiceDB(FilmRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Film makeMovie(Film film) {
		return this.repo.save(film);
	}

	@Override
	public List<Film> getAllFilms() {
		return this.repo.findAll();
	}

	@Override
	public Film getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Film updateFilm(int id, String name, Double cost, String genre) {
		Film toUpdate = this.repo.findById(id).get();  // fetches existing data from db

		if (name != null && !name.isBlank())
			toUpdate.setName(name);
		if (cost != null)
			toUpdate.setCost(cost);
		if (name != null && !name.isBlank())
			toUpdate.setGenre(genre);

		return this.repo.save(toUpdate); // saves new data and returns it 
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);

	}

}
