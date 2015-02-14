package br.com.ufpb.game;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import br.com.ufpb.lesson.Lesson;
import br.com.ufpb.matharrow.R;
import br.com.ufpb.question.Question;
import br.com.ufpb.screen.ActivityGameArrow;
import br.com.ufpb.screen.CreateRecord;
import br.com.ufpb.util.Alert;

public class Control {

	private Question question;
	private Lesson lesson;
	private float gameScore;
	private int attempts;
	private int indexQuestion;
	private ActivityGameArrow activity;
	private SoundPool sound;
	private int soundIDtiro;
	private int soundIDcollision;

	public Control(ActivityGameArrow activity) {
		this.lesson = activity.getLesson(); 
		this.activity = activity;
		this.generatQuestion();
		this.attempts = 10;
		this.gameScore = 0;
		loadSound();
	}

	@SuppressWarnings("deprecation")
	private void loadSound() {
		this.sound = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
		this.soundIDtiro = sound.load(activity, R.raw.arrow, 1);
		this.soundIDcollision = sound.load(activity, R.raw.collision, 1);
	}

	private void generatQuestion() {
		try {
			question = lesson.getQuestions().get(indexQuestion);
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
