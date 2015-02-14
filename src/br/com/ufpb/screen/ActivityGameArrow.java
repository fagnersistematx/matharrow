package br.com.ufpb.screen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import br.com.ufpb.game.GameArrow;
import br.com.ufpb.lesson.Lesson;
import br.com.ufpb.matharrow.R;
import br.com.ufpb.util.Alert;

@SuppressLint("ShowToast")
public class ActivityGameArrow extends Activity {

	private Activity myActivity = this;
	private GameArrow gameArrow;
	private TextView viewTentativa;
	private TextView viewQuestion;
	private TextView viewGameStore;
	private ImageButton btHelp;
	private RelativeLayout rl;
	private Alert alertMensage;
	private Lesson lesson;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_game_arrow);
		
		rl = (RelativeLayout) findViewById(R.id.layoutGame);
		viewTentativa = (TextView) findViewById(R.id.text_attempts);
		viewQuestion = (TextView) findViewById(R.id.text_question);
		viewGameStore = (TextView) findViewById(R.id.text_store);
		btHelp = (ImageButton) findViewById(R.id.bt_help);
		Intent intent = getIntent();
		lesson = (Lesson) intent.getSerializableExtra("LESSON");	

		gameArrow = new GameArrow(this);
		rl.addView(gameArrow);
		Thread myGame = new Thread(gameArrow);
		myGame.setPriority(Thread.MIN_PRIORITY);
		myGame.start();
		
		btHelp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(myActivity, Help.class);
				intent.putExtra("LESSON_HELP", lesson.getHelp());
				startActivity(intent);
			}
		});

	}
		
	protected void onDestroy() {
		super.onDestroy();
		gameArrow.release();
	}

	public TextView getViewTentativa() {
		return viewTentativa;
	}

	public void setViewTentativa(TextView viewTentativa) {
		this.viewTentativa = viewTentativa;
	}

	public TextView getViewQuestion() {
		return viewQuestion;
	}

	public void setViewQuestion(TextView viewQuestion) {
		this.viewQuestion = viewQuestion;
	}	

	public TextView getViewGameStore() {
		return viewGameStore;
	}

	public void setViewGameStore(TextView viewGameStore) {
		this.viewGameStore = viewGameStore;
	}

	public RelativeLayout getRl() {
		return rl;
	}

	public void setRl(RelativeLayout rl) {
		this.rl = rl;
	}	

	public Alert getAlertMensage() {
		return alertMensage;
	}

	public void setAlertMensage(Alert alertMensage) {
		this.alertMensage = alertMensage;
	}
	
	public Lesson getLesson() {
		return lesson;
	}

}
