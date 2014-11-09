package br.com.ufpb.prolicen.screen;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import br.com.ufpb.prolicen.arrowfraction.Player;
import br.com.ufpb.prolicen.arrowfraction.R;
import br.com.ufpb.util.ConexaoBanco;

public class Record extends Activity {

	private Activity myActivity = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record);
		
		ConexaoBanco cb = new ConexaoBanco(myActivity);
		List <Player> players = cb.getPlayers();
		
		String[] itens = { "Números inteiros" };
		ListView list = (ListView) findViewById(R.id.list_records);
		list.setAdapter(new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, players));	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.record, menu);
		return true;
	}

}
