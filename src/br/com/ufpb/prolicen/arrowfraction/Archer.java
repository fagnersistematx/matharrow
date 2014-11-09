package br.com.ufpb.prolicen.arrowfraction;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Archer extends GameObject {

	public Archer(int x, int y, Bitmap bitmap) {
		super(x, y, bitmap.getWidth(), bitmap.getHeight(), bitmap);
	}

	public void draw(Canvas canvas, Paint paint) {
		paint.setColor(Color.RED);
		canvas.drawBitmap(getBitmap(), getX(), getY(), paint);
	}

}
