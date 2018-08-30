package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class CD {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String title;
	
	@OneToMany
	(
		 cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true
	)
	
	private Collection<Artist>artists;
	
	public CD() {}

	public CD(long id, String title, Collection<Artist> artists) 
	{
		super();
		this.id = id;
		this.title = title;
		this.artists = artists;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public Collection<Artist> getArtists() 
	{
		return artists;
	}

	public void setArtists(Collection<Artist> artists)
	{
		this.artists = artists;
	}
		
}
