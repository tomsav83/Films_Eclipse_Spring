package com.qa.films.domain;



public class Film {
	
	
	private String name;
	
	private double cost;
	
	private String genre;

	public Film(String name, double cost, String genre) {
		super();
		this.name = name;
		this.cost = cost;
		this.genre = genre;
		
		
	}
	public Film() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Film [name=" + name + ", cost=" + cost + ", genre=" + genre + "]";
	}
	
	
}
		
		