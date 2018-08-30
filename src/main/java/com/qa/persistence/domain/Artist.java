package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	private String genre;
	private String song;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenres() {
		return genre;
	}
	
	public void setGenres(String genre) {
		this.genre = genre;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}
	
}
