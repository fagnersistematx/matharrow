package br.com.ufpb.player;

public class Player {

	private int id;
	private String name;
	private Double score;		
	
	public Player() {
		super();
	}

	public Player(String name, Double score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public Player(int id, String name, Double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
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
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Pontuação: " + score + ", Nome: " + name;
	}	
	
	
	
}
