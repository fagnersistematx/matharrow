package br.com.ufpb.prolicen.screen;

import br.com.ufpb.prolicen.arrowfraction.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Phases extends Activity {
	private Activity myActivity = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phases);
		String[] itens = { "Números inteiros" };
		ListView list = (ListView) findViewById(R.id.listPhases);
		list.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, itens));

		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {				
				switch(arg2){
					case 0:		
						Intent intent1 = new Intent(myActivity, ActivityGameArrow.class);
						startActivity(intent1);
						break;
					case 1:
						Intent intent2 = new Intent(myActivity, ActivityGameArrow.class);
						startActivity(intent2);
						break;
					case 2:
						break;
					case 3:
						break;
				}						
			}

		});
	}
}
