package com.org.movielibrary.dto;

public class MovieRequestModel {

	private Long id;
	private String title;
	private String director;
	private String releaseDate;
	private String type;

	public MovieRequestModel(String title, String director, String releaseDate, String type) {
		super();
		this.title = title;
		this.director = director;
		this.releaseDate = releaseDate;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
