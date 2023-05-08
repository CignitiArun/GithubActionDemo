package org.example;

import java.util.List;

public class Report {
	private List<Elements> elements;
	private String name;
	private String description;
	private String id;
	private String keyword;
	private String uri;
	private List<Tags> tags;	
	
	public List<Elements> getElements() {
		return elements;
	}

	public void setElements(List<Elements> elements) {
		this.elements = elements;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "Report [elements=" + elements + "]";
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	
	
}