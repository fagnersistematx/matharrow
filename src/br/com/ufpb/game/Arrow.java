package br.com.ufpb.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Arrow extends GameObject {

	public Arrow(int x, int y, int width, int heigth, Bitmap bitmap) {
		super(x, y, bitmap.getWidth(), bitmap.getHeight(), bitmap);
	}

	public void mexe(int width, int heigth) {
		if (getX() > width) {
			setX(getX() + 30);
		} else {
			setX(getX() + 30);
		}
	}

	public void draw(Canvas canvas, Paint paint) {
		paint.setColor(Color.BLUE);
		canvas.drawBitmap(getBitmap(), getX(), getY(), paint);
	}

}
