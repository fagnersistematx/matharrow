package br.com.ufpb.prolicen.arrowfraction;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import br.com.ufpb.prolicen.question.Question;
import br.com.ufpb.prolicen.question.QuestionsControl;
import br.com.ufpb.prolicen.screen.ActivityGameArrow;
import br.com.ufpb.prolicen.screen.CreateRecord;
import br.com.ufpb.util.Alert;

public class Control {

	private final int ATTEMPTS_EASY = 15;
	private final int ATTEMPTS_AVERAGE = 10;
	private final int ATTEMPTS_DIFFICULT = 5;

	private Question question;
	private QuestionsControl questionsControl;
	private float gameScore;
	private int attempts;
	private int level;
	private int indexQuestion;
	private ActivityGameArrow activity;
	private SoundPool sound;
	private int soundIDtiro;
	private int soundIDcollision;

	public Control(ActivityGameArrow activity) {
		this.questionsControl = QuestionsControl.getInstance();
		this.activity = activity;
		this.generatQuestion();
		this.attempts = 10;// getInitialAttempts();
		this.gameScore = 0;
		loadSound();
	}

	private void loadSound() {
		this.sound = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
		this.soundIDtiro = sound.load(activity, R.raw.arrow, 1);
		this.soundIDcollision = sound.load(activity, R.raw.collision, 1);
	}

	// private int getInitialAttempts() {
	// if (level == 2) {
	// return (int) (question.getAnswer() + ATTEMPTS_DIFFICULT);
	// } else if (level == 1) {
	// return (int) (question.getAnswer() + ATTEMPTS_AVERAGE);
	// } else {
	// return (int) (question.getAnswer() + ATTEMPTS_EASY);
	// }
	// }

	private void generatQuestion() {
		try {
			question = questionsControl.getQuestion(indexQuestion);
			++indexQuestion;
		} catch (Exception e) {			
			activity.runOnUiThread((new Alert(activity, "Parabéns.",
					"Reiniciar", Alert.ARCHER_HAPPY)));
			createRecord();
		}
	}

	public void createRecord() {
		Intent intent = new Intent(activity, CreateRecord.class);
		intent.putExtra("SCORE", gameScore);
		activity.startActivity(intent);
		sound.release();
		sound = null;
		activity.finish();
	}

	public boolean confirm(String answer) {

		boolean confirm;
		if (question.getAnswer().equalsIgnoreCase(answer)) {
			++gameScore;
			gameScore += attempts;
			attempts = 10;
			generatQuestion();
			confirm = true;
		} else {
			confirm = false;
		}

		return confirm;
	}

	public void playSoundArrow() {
		int streamIDtiro = sound.play(soundIDtiro, 1f, 1f, 0, 0, 1f);
	}
	
	
	public void playSoundCollision() {
		int streamIDCollision = sound.play(soundIDcollision, 1f, 1f, 0, 0, 1f);
	}

	public void decrementAttempts() {
		--this.attempts;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public float getGameScore() {
		return gameScore;
	}

	public void setGameScore(float gameScore) {
		this.gameScore = gameScore;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

}
