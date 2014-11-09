package br.com.ufpb.prolicen.arrowfraction;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.prolicen.question.Question;
import br.com.ufpb.prolicen.screen.ActivityGameArrow;
import br.com.ufpb.util.Alert;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

@SuppressLint("ViewConstructor")
public class GameArrow extends View implements Runnable {

	private boolean running = true;
	private static final int INTERVAL = 100;
	private Paint paint;
	private Archer archer;
	private Apple[] apples;
	private List<Arrow> arrows;
	private ActivityGameArrow activity;
	private Control control;

	public GameArrow(ActivityGameArrow activity) {
		super(activity);
		this.activity = activity;
		this.control = new Control(activity);
		paint = new Paint();
	}

	@Override
	public void run() {
		while (running) {
			try {
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				Log.e("Arrow Fraction - erro", e.getMessage());
			}
			update();
		}

	}

	private void update() {
		if (apples == null) {
			return;
		}
		for (int i = 0; i < apples.length; i++) {
			try {
				apples[i].mexe(getWidth(), getHeight());
			} catch (Exception erro) {
				Log.w("Erro gerado", getWidth()+" | "+ getHeight());
			}
		}
		for (Arrow a : arrows) {
			try {
				a.mexe(getWidth(), getHeight());
				int x = (int) a.getX();
				int y = (int) a.getY();
				for (int i = 0; i < apples.length; i++) {
					if (apples[i].colide(x, y)) {
						apples[i].setX(-50);
						a.setY(-100);
						control.playSoundCollision();
						if (!control.confirm(apples[i].getResposta())) {
							activity.runOnUiThread((new Alert(activity,
									"Resposta Incorreta.", "Reiniciar",
									Alert.ARCHER_SAD)));
							if (control.getGameScore() > 0) {
								control.createRecord();
							}
							resetGame();
						} else {
							activity.runOnUiThread((new Alert(activity,
									"Resposta Correta.", "Continuar",
									Alert.ARCHER_HAPPY)));
							nextGame();
						}

					}
				}
			} catch (Exception erro) {
				Log.w("Erro gerado", erro);
			}
		}
		atualizarPontuacao();
		// chama o metodo draw
		postInvalidate();
	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		if (archer == null) {
			initGame();
		}
		canvas.drawColor(Color.WHITE);

		archer.draw(canvas, paint);

		for (int i = 0; i < 3; i++) {
			apples[i].draw(canvas, paint);
		}

		for (Arrow a : arrows) {
			a.draw(canvas, paint);
		}

	}

	public void release() {
		running = false;
	}

	public void initGame() {
		int correctAnswer = (int) (Math.random() * 3);
		Bitmap bitmapArcher = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow);
		archer = new Archer(10, (getHeight() / 2), bitmapArcher);
		arrows = new ArrayList<Arrow>();
		apples = new Apple[3];
		// apples = new Apple[getHeight() / 50];

		Bitmap bitmapApple = BitmapFactory.decodeResource(getResources(),
				R.drawable.apple);
		for (int i = 0; i < 3; i++) {
			int y = i * -50;
			int x = (getWidth() / 2)
					+ (int) (Math.random() * ((getWidth() - 30) - (getWidth() / 2)));
			apples[i] = new Apple(x, y, 25, 25, bitmapApple);
			if (i == correctAnswer) {
				apples[i].setResposta(control.getQuestion().getAnswer());
			} else {
				Question question = control.getQuestion();
				apples[i].setResposta(question.getIncorrectAnswer((int) (Math
						.random() * question.sizeIncorrectAnswers())));
			}
		}
	}

	public void resetGame() {
		activity.getViewTentativa().setTextColor(Color.BLACK);
		this.control = new Control(activity);
		this.nextGame();
	}

	public void nextGame() {
		paint = new Paint();
		archer = null;
	}

	public boolean onTouchEvent(MotionEvent event) {
		
		control.playSoundArrow();

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			int x = (int) event.getX();
			int y = (int) event.getY();

			if (archer.colide(x, y)) {
				if (control.getAttempts() > 0) {
					Bitmap bitmapArrow = BitmapFactory.decodeResource(
							getResources(), R.drawable.seta);
					arrows.add(new Arrow(archer.getX(), archer.getY(), archer
							.getWidth(), archer.getHeigth(), bitmapArrow));

					control.decrementAttempts();
				} else {
					activity.getViewTentativa().setTextColor(Color.RED);
					activity.setAlertMensage(new Alert(activity,
							"Não há mais tentativas.", "Reiniciar",
							Alert.ARCHER_AMAZED));
					activity.getAlertMensage().show();
					if (control.getGameScore() > 0) {
						control.createRecord();
					}
					resetGame();
				}

			}

		}

		return super.onTouchEvent(event);
	}

	private void atualizarPontuacao() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				activity.getViewQuestion().setText(
						control.getQuestion().getQuestion());
				activity.getViewGameStore().setText(
						"Pontuação: " + control.getGameScore() + " ");

				activity.getViewTentativa().setText(
						"Tentativas: " + control.getAttempts() + " ");
			}
		});
	}
}
