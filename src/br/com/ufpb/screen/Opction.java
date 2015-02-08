package br.com.ufpb.screen;

import br.com.ufpb.matharrow.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Opction extends Activity {

	private ImageButton btAbout;
	private ImageButton btRecord;
	private ImageButton menu_config_voltar;
	private ImageButton menu_config_sair;
	private ImageButton btTeam;
	private Intent intent;
	private Activity myActivity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opction);
		
		btAbout = (ImageButton) findViewById(R.id.about);
		btRecord = (ImageButton) findViewById(R.id.record);
		btTeam = (ImageButton) findViewById(R.id.team);
		menu_config_voltar = (ImageButton) findViewById(R.id.menu_config_voltar);
		menu_config_sair = (ImageButton) findViewById(R.id.menu_config_exit);
		
		btAbout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				intent = new Intent(myActivity, About.class);
				startActivity(intent);
			}
		});

		btRecord.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				intent = new Intent(myActivity, Record.class);
				startActivity(intent);
			}
		});

		btTeam.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				intent = new Intent(myActivity, Team.class);
				startActivity(intent);
			}
		});
		
		menu_config_voltar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				intent = new Intent(myActivity, Start.class);
				startActivity(intent);
			}
		});
		
		menu_config_sair.setOnClickListener(new View.OnClickListener() {

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
