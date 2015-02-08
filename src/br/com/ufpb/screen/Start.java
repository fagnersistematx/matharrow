package br.com.ufpb.screen;

import br.com.ufpb.matharrow.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Start extends Activity {
	
	private ImageButton menuConfig;
	private ImageButton menuExit;
	private ImageButton btStart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		menuConfig = (ImageButton) findViewById(R.id.menu_config);
		menuExit = (ImageButton) findViewById(R.id.menu_exit);
		btStart = (ImageButton) findViewById(R.id.bt_start);
		
		btStart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intentSelect = new Intent(Start.this, Phases.class);
				startActivity(intentSelect);
			}
		});
		
		menuConfig.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intentSelect = new Intent(Start.this, Opction.class);
				startActivity(intentSelect);
			}
		});
		
		menuExit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});
		
	}
}
