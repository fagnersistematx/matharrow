package br.com.ufpb.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Apple extends GameObject {

	private String resposta;
	
	public Apple(int x, int y, int width, int heigth, Bitmap bitmap) {
		super(x, y, bitmap.getWidth(), bitmap.getHeight(), bitmap);
	}

	public void mexe(int width, int heigth) {
		if (getY() < heigth) {
			setY(getY() + 5);
		} else {
			setY(-5);
			int x = (width / 2)
					+ (int) (Math.random() * ((width - 30) - (width / 2)));
			setX(x);
		}
	}

	public void draw(Canvas canvas, Paint paint) {
		paint.setColor(Color.WHITE);
		paint.setTextSize(20);
		canvas.drawBitmap(getBitmap(), getX(), getY(), paint);
		//DecimalFormat df = new DecimalFormat("0.00"); 
		canvas.drawText(resposta, getX(), getY(), paint);
	}

	@Override
	public boolean colide(int x2, int y2) {

		x2 += 0;
		y2 += 15;

		if (x2 > getX() + getWidth())
			return false;
		if (y2 > getY() + getHeigth())
			return false;
		if (x2 < getX())
			return false;
		if (y2 < getY())
			return false;

		return true;

	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}		

}
