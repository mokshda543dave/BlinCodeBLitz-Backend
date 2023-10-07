package com.smoke.screen.payloads;

import java.util.Date;

public class SolutionDTO {

	private Integer id;
	private UserDTO user;
	private String solutionQ1;
	private String langQ1;
	private String solutionQ2;
	private String langQ2;
	private String solutionQ3;
	private String langQ3;
	private Integer flashCount;
	private String timeTaken;
	private Date addedDate;

//	No Args Constructor

	public SolutionDTO() {
		super();
	}

//	Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getSolutionQ1() {
		return solutionQ1;
	}

	public void setSolutionQ1(String solutionQ1) {
		this.solutionQ1 = solutionQ1;
	}

	public String getLangQ1() {
		return langQ1;
	}

	public void setLangQ1(String langQ1) {
		this.langQ1 = langQ1;
	}

	public String getSolutionQ2() {
		return solutionQ2;
	}

	public void setSolutionQ2(String solutionQ2) {
		this.solutionQ2 = solutionQ2;
	}

	public String getLangQ2() {
		return langQ2;
	}

	public void setLangQ2(String langQ2) {
		this.langQ2 = langQ2;
	}

	public String getSolutionQ3() {
		return solutionQ3;
	}

	public void setSolutionQ3(String solutionQ3) {
		this.solutionQ3 = solutionQ3;
	}

	public String getLangQ3() {
		return langQ3;
	}

	public void setLangQ3(String langQ3) {
		this.langQ3 = langQ3;
	}

	public Integer getFlashCount() {
		return flashCount;
	}

	public void setFlashCount(Integer flashCount) {
		this.flashCount = flashCount;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	

}
