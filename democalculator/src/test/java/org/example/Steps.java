package org.example;

import java.util.List;

public class Steps {
	private String name;
	private Result result;
	private int line;
	private String keyword;
	private Match match;
	private List<String> output;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "Steps [name=" + name + ", result=" + result + "]";
	}

	public List<String> getOutput() {
		return output;
	}

	public void setOutput(List<String> output) {
		this.output = output;
	}

}
