package com.qa.films.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	

	@Autowired
	public FilmsController(FilmService service) {
	super();
	this.service = service;
	}

	
	
	@GetMapping("/hello")
	public String greeting() {
		return "Hello,world!";
	}
		
		// CREATE
	@PostMapping("/createFilm")
	public ResponseEntity<Film> makeMovie(@RequestBody Film film) {
		System.out.println("Body: " + film);
		return new ResponseEntity<Film>(this.service.makeMovie(film), HttpStatus.CREATED);
	}
	
		// GENERIC TERM FOR @GetMapping
	@RequestMapping(method = RequestMethod.GET, path = "/getAll")
	public List<Film> getAllFilms() {
		return this.service.getAllFilms();
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Film> getById(@PathVariable int id) {
		System.out.println("ID: " + id);
		return new ResponseEntity<Film>(this.service.getById(id), HttpStatus.OK);
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Film> updateFilm(@PathVariable int id, @PathParam("name") String name, 
			@PathParam("cost") Double cost, @PathParam("genre") String genre) {
		System.out.println("ID: " + id);
		System.out.println("NAME: " + name);
		System.out.println("COST: " + cost);
		System.out.println("GENRE: " + genre);

		return new ResponseEntity<Film>(this.service.updateFilm(id, name, cost, genre), HttpStatus.OK);

	}
	
	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
		this.service.delete(id);
	}
		
}
