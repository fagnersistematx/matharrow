package br.com.ufpb.prolicen.arrowfraction;

import android.graphics.Bitmap;

public class GameObject {
	
	private int x;
	private int y;
	private int width;
	private int heigth;
	private Bitmap bitmap;

	public GameObject(int x, int y, int width, int heigth,  Bitmap bitmap) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
		this.bitmap = bitmap;
	}

	public boolean colide(GameObject gameObject) {
		// esta a direita
		if (gameObject.getX() > x + width)
			return false;
		// esta abaixo
		if (gameObject.getY() > y + heigth)
			return false;
		// esta abaixo
		if (gameObject.getX() + gameObject.getWidth() < x)
			return false;
		// esta abaixo
		if (gameObject.getY() + gameObject.getHeigth() < y)
			return false;

		return true;
	}

	public boolean colide(int x2, int y2) {
		if (x2 > x + width)
			return false;
		if (y2 > y + heigth)
			return false;
		if (x2 < x)
			return false;
		if (y2 < y)
			return false;

		return true;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

}
