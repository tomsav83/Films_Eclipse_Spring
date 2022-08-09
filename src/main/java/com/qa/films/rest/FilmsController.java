package com.qa.films.rest;

//import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.films.domain.Film;
import com.qa.films.service.FilmService;



@RestController
public class FilmsController {
	
	private FilmService service;
	
//	private List<Film> films;
	
//	public FilmsController() {
//		super();
//		this.films = new ArrayList<>();
//		this.films.add(new Film("LOTR", 15.50, "Fantasy"));
//	}

	
	@GetMapping("/hello")
	public String greeting() {
		return "Hello,world!";
	}
		
		// CREATE
	@PostMapping("/createFilm")
	public Film makeMovie(@RequestBody Film film) {
		System.out.println("Body: " + film);
//		this.films.add(film);
//		return films.get(this.films.size() -1);
		return this.service.makeMovie(film);
	}
	
		// GENERIC TERM FOR @GetMapping
	@RequestMapping(method = RequestMethod.GET, path = "/getAll")
	public List<Film> getAllFilms() {
//		return this.films;
		return this.service.getAllFilms();
	}
	
//		// GET
//	@GetMapping("/getAll")
//	public List<Film> getAllFilms() {
//		return this.films;
//		
//	}
	
	@GetMapping("/get/{id}")
	public Film getById(@PathVariable int id) {
		System.out.println("ID: " + id);
//		return this.films.get(id);
		return this.service.getById(id);
	}
	
	@PatchMapping("/update/{id}")
	public Film updateFilm(@PathVariable int id, @PathParam("name") String name, 
			@PathParam("cost") Double cost, @PathParam("genre") String genre) {
		System.out.println("ID: " + id);
		System.out.println("NAME: " + name);
		System.out.println("COST: " + cost);
		System.out.println("GENRE: " + genre);
//			Film toUpdate = this.films.get(id);
//		if (name != null && name.isBlank()) toUpdate.setName(name);
//		if (cost != null) toUpdate.setCost(cost);
//		if (genre != null && genre.isBlank()) toUpdate.setGenre(genre);
		
//		return toUpdate;
		return this.service.updateFilm(id, name, cost, genre);
	}
	
	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
//		this.films.remove(id);
		this.service.delete(id);
	}
		
}
