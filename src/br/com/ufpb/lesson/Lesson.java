package br.com.ufpb.lesson;

import java.io.Serializable;
import java.util.List;

import br.com.ufpb.question.Question;

public class Lesson implements  Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String help;
	private List<Question> questions;
	
	public Lesson(){
	}
	
	public Lesson(int id, String name, String help) {
		super();
		this.id = id;
		this.name = name;
		this.help = help;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", name=" + name + ", help=" + help
				+ ", questions=" + questions + "]";
	}
	
}
