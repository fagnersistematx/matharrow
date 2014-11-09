package br.com.ufpb.prolicen.screen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import br.com.ufpb.prolicen.arrowfraction.GameArrow;
import br.com.ufpb.prolicen.arrowfraction.R;
import br.com.ufpb.util.Alert;

@SuppressLint("ShowToast")
public class ActivityGameArrow extends Activity {

	private GameArrow gameArrow;
	private TextView viewTentativa;
	private TextView viewQuestion;
	private TextView viewGameStore;
	private RelativeLayout rl;
	private Alert alertMensage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_game_arrow);
		rl = (RelativeLayout) findViewById(R.id.layoutGame);
		viewTentativa = (TextView) findViewById(R.id.text_attempts);
		viewQuestion = (TextView) findViewById(R.id.text_question);
		viewGameStore = (TextView) findViewById(R.id.text_store);		

		gameArrow = new GameArrow(this);
		rl.addView(gameArrow);
		Thread myGame = new Thread(gameArrow);
		myGame.setPriority(Thread.MIN_PRIORITY);
		myGame.start();

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

}
