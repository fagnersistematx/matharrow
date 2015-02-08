package br.com.ufpb.screen;

import br.com.ufpb.matharrow.R;
import br.com.ufpb.player.Player;
import br.com.ufpb.player.PlayerControl;
import br.com.ufpb.util.DatabaseConnection;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateRecord extends Activity {

	private Activity myActivity = this;
	private TextView playerName;
	private float gameScore;
	private PlayerControl playerControl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_record);
		
		Intent intent = getIntent();
		playerControl = new PlayerControl(myActivity);
		gameScore = intent.getFloatExtra("SCORE", 0);
		TextView  tv_score = (TextView) findViewById(R.id.create_record_score);
		playerName = (TextView) findViewById(R.id.player_name);
		Button btSalvar = (Button) findViewById(R.id.bt_salva);
		Button btCancelar = (Button) findViewById(R.id.bt_cancelar);
		
		tv_score.setText("Pontuação: "+ gameScore );
		
		btSalvar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				playerControl.addPlyer(new Player(playerName.getText().toString(), (double) gameScore));				
								
				Intent intent2 = new Intent(myActivity, Record.class);
				startActivity(intent2);
				finish();

			}
		});
		
		btCancelar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent record = new Intent(myActivity, Record.class);
				startActivity(record);
				finish();
			}
		});

	}
	
	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    DatabaseConnection.getInstance(myActivity);
		DatabaseConnection.closeDatabase();
	}
}
