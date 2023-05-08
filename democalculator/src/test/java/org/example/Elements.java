package org.example;

import java.util.List;

public class Elements {
	
	private List<Steps> steps;
	private String start_timestamp;
	private Long line;
	private String name;	
	private String description;
	private String id;
	private String type;
	private String keyword;
	private List<Tags> tags;
	private List<Before> before;
	private List<After> after;
	
	public String getStart_timestamp() {
		return start_timestamp;
	}

	public void setStart_timestamp(String start_timestamp) {
		this.start_timestamp = start_timestamp;
	}

	public Long getLine() {
		return line;
	}

	public void setLine(Long line) {
		this.line = line;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public List<Steps> getSteps() {
		return steps;
	}

	public void setSteps(List<Steps> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "Elements [steps=" + steps + "]";
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public List<Before> getBefore() {
		return before;
	}

	public void setBefore(List<Before> before) {
		this.before = before;
	}

	public List<After> getAfter() {
		return after;
	}

	public void setAfter(List<After> after) {
		this.after = after;
	}

	
	
	
}
