package com.qa.films.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.films.domain.Film;

@Repository
public interface FilmRepo extends JpaRepository<Film, Integer> {

}
