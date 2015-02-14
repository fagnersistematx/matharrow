package br.com.ufpb.screen;

import java.util.List;
import br.com.ufpb.lesson.Lesson;
import br.com.ufpb.lesson.LessonControl;
import br.com.ufpb.matharrow.R;
import br.com.ufpb.util.DatabaseConnection;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Phases extends Activity {
	
	private Activity myActivity = this;
	private LessonControl lessonControl;
	private List<Lesson> lessons;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phases);
		
		this.lessonControl = new LessonControl(this);	
		
		lessons = lessonControl.getLesson();
				
		String[] itens = new String[lessons.size()];
		
		for(int i = 0; i < lessons.size(); ++i){
			itens[i] = lessons.get(i).getName();
		}
		
		ListView list = (ListView) findViewById(R.id.listPhases);
		
		list.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, itens));

		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int posicao,
					long arg3) {	
							
				Log.i("Le", lessons.get(posicao).toString());
				
				Intent intent1 = new Intent(myActivity, ActivityGameArrow.class);
				intent1.putExtra("LESSON", lessons.get(posicao));
				startActivity(intent1);
			}

		});
	}
	
	@Override
	protected void onDestroy() {
	    super.onDestroy();
		DatabaseConnection.closeDatabase();
	}
}
