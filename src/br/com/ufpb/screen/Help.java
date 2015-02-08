package br.com.ufpb.screen;

import br.com.ufpb.matharrow.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Help extends Activity {
	
	private TextView tvHelp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		
		tvHelp = (TextView) findViewById(R.id.text_help);

		Bundle extras = getIntent().getExtras();
		String help = extras.getString("LESSON_HELP");
		
		tvHelp.setText(help);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help, menu);
		return true;
	}

}
