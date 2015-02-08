package br.com.ufpb.util;

import br.com.ufpb.matharrow.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Alert implements Runnable {

	private AlertDialog alerta;
	private ImageView imageView;
	private Button button;
	private View view;
	public static final int ARCHER_HAPPY = 1;
	public static final int ARCHER_SAD = 2;
	public static final int ARCHER_AMAZED = 3;
	private Activity activity;
    private String title;
    private String textButton;
    private int imageOption;
    
	public Alert(final Activity activity, String title, String textButton, int imageOption) {
		
		this.activity = activity;
		this.title = title;
		this.textButton = textButton;
		this.imageOption = imageOption;		
	}

	private void selecteImage(int imageOption) {
		
		imageView = (ImageView) view.findViewById(R.id.image_alert);
		
		switch (imageOption) {
		case 1:
			imageView.setImageResource(R.drawable.archer_happy);
			break;
		case 2:
			imageView.setImageResource(R.drawable.archer_sad);
			break;
		case 3:
			imageView.setImageResource(R.drawable.archer_amazed);
			break;

		default:
			break;
		}
	}

	public void show() {
		LayoutInflater li = activity.getLayoutInflater();
		view = li.inflate(R.layout.alert, null);
		
		this.selecteImage(imageOption);
		
		button = (Button) view.findViewById(R.id.bt_confirmation);
		button.setText(textButton);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				alerta.dismiss();
			}
		});

		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setTitle(title);
		builder.setView(view);
		alerta = builder.create();
		alerta.show();
	}

	@Override
	public void run() {		
		this.show();
	}

}
