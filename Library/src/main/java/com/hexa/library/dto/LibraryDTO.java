package com.hexa.library.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class LibraryDTO {
	private long iSBN;
	private String title;
    private String author;
    private String genre;
    private String publicationYear;
    private String publisher;
    private long totalcopies;
	public LibraryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LibraryDTO(String title, String author, long iSBN, String genre, String publicationYear, String publisher,
			long totalcopies) {
		super();
		this.title = title;
		this.author = author;
		this.iSBN = iSBN;
		this.genre = genre;
		this.publicationYear = publicationYear;
		this.publisher = publisher;
		this.totalcopies = totalcopies;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getISBN() {
		return iSBN;
	}
	public void setISBN(long iSBN) {
		this.iSBN = iSBN;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public long getTotalcopies() {
		return totalcopies;
	}
	public void setTotalcopies(long totalcopies) {
		this.totalcopies = totalcopies;
	}
	@Override
	public String toString() {
		return "LibraryDTO [title=" + title + ", author=" + author + ", iSBN=" + iSBN + ", genre=" + genre
				+ ", publicationYear=" + publicationYear + ", publisher=" + publisher + ", totalcopies=" + totalcopies
				+ "]";
	}
	
}
