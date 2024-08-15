package com.video;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String videoUrl;
	@ElementCollection
	private List<String> tags;
	private LocalDateTime uploadDateTime;

	// Constructors, getters, and setters

	public Video() {
		this.uploadDateTime = LocalDateTime.now();
	}

	public Video(String title, String description, String videoUrl, List<String> tags) {
		this.title = title;
		this.description = description;
		this.videoUrl = videoUrl;
		this.tags = tags;
		this.uploadDateTime = LocalDateTime.now();
	}

	// Getters and Setters

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public LocalDateTime getUploadDateTime() {
		return uploadDateTime;
	}

	public void setUploadDateTime(LocalDateTime uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}
}
