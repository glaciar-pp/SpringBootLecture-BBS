package com.mulcam.demo.entity;

public class Chart {
	private int rank;
	private String image;
	private String title;
	private String artist;
	private String album;
	public Chart() { }
	public Chart(int rank, String image, String title, String artist, String album) {
		this.rank = rank;
		this.image = image;
		this.title = title;
		this.artist = artist;
		this.album = album;
	}
	@Override
	public String toString() {
		return "Genie [rank=" + rank + ", image=" + image + ", title=" + title + ", artist=" + artist + ", album="
				+ album + "]";
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
}
