package br.com.ufpb.screen;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.ufpb.matharrow.R;
import br.com.ufpb.player.Player;
import br.com.ufpb.player.PlayerControl;
import br.com.ufpb.util.DatabaseConnection;

public class Record extends Activity {

	private Activity myActivity = this;
	private PlayerControl playerControl;
	private ListView list;
	private List <Player> players;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record);
				
		playerControl = new PlayerControl(myActivity);
		players = playerControl.getPlayers();
		
		list = (ListView) findViewById(R.id.list_records);
		list.setAdapter(new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, players));	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.record, menu);		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {	   
	    switch (item.getItemId()) {
	        case R.id.menu_record_come_back:
	        	Intent intent2 = new Intent(myActivity, Opction.class);
				startActivity(intent2);
	            return true;
	        case R.id.menu_record_delete:
	        	playerControl.deletePleyers();
	        	list.setAdapter(new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, players));
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	protected void onDestroy() {
	    super.onDestroy();
		DatabaseConnection.closeDatabase();
	}

}
