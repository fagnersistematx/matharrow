package br.com.ufpb.prolicen.screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.ufpb.prolicen.arrowfraction.R;

public class Opction extends Activity {

	private Button btStart;
	private Button btAbout;
	private Button btRecord;
	private Intent intent;
	private Button btExit;
	private Activity myActivity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opction);

		btStart = (Button) findViewById(R.id.start);
		btAbout = (Button) findViewById(R.id.about);
		btRecord = (Button) findViewById(R.id.record);
		btExit = (Button) findViewById(R.id.exit);
			

		btStart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//Intent intent2 = new Intent(myActivity, ActivityGameArrow.class);
				Intent intent2 = new Intent(myActivity, Phases.class);
				startActivity(intent2);

			}
		});

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
				intent = new Intent(myActivity,Record.class);
				startActivity(intent);

			}
		});
		
		btExit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {		
				finish();
			}
		});
	}

}
