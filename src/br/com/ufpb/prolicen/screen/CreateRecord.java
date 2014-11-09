package br.com.ufpb.prolicen.screen;

import br.com.ufpb.prolicen.arrowfraction.R;
import br.com.ufpb.util.ConexaoBanco;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_record);
		
		Intent intent = getIntent();
		gameScore = intent.getFloatExtra("SCORE", 0);
		TextView  tv_score = (TextView) findViewById(R.id.create_record_score);
		playerName = (TextView) findViewById(R.id.player_name);
		Button btSalvar = (Button) findViewById(R.id.bt_salva);
		Button btCancelar = (Button) findViewById(R.id.bt_cancelar);
		
		tv_score.setText("Pontuação: "+ gameScore );
		
		btSalvar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				ConexaoBanco cb = new ConexaoBanco(myActivity);
				cb.insertJogador(playerName.getText().toString(), gameScore);
				
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
}
