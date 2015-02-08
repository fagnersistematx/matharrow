package br.com.ufpb.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fagner
 * 
 */
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int activity_id;
	private String question;
	private String answer;
	private List<String> incorrectAnswers;
	
	public Question() {
		super();
	}

	public Question(int id, String question, String answer) {
		this.incorrectAnswers = new ArrayList<String>();
		this.id = id;
		this.question = question;
		this.answer = answer;		
	}
	
	public void addIncorrectAnswer(String incorrectAnswer){
		this.incorrectAnswers.add(incorrectAnswer);
	}
	
	public String getIncorrectAnswer(int index){
		return this.incorrectAnswers.get(index);
	}
	
	public int sizeIncorrectAnswers(){
		return this.incorrectAnswers.size();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}	
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", activity_id=" + activity_id
				+ ", question=" + question + ", answer=" + answer
				+ ", incorrectAnswers=" + incorrectAnswers + "]";
	}
	
}
