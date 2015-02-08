package br.com.ufpb.screen;

import br.com.ufpb.lesson.LessonException;
import br.com.ufpb.matharrow.R;
import br.com.ufpb.question.QuestionException;
import br.com.ufpb.util.Alert;
import br.com.ufpb.util.DatabaseConnection;
import br.com.ufpb.util.UpdateDatabase;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Team extends Activity {

	private Button btImport;
	private EditText edCode;
	private UpdateDatabase up;
	private Activity myActivity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team);
		
		this.up = new UpdateDatabase(myActivity);

		btImport = (Button) findViewById(R.id.import_tean);
		edCode = (EditText) findViewById(R.id.code_team);

		btImport.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try {					
					up.updateLesson(edCode.getText().toString());
					new Alert(myActivity, "Atualizado.", "Fechar",
							Alert.ARCHER_HAPPY).show();
				} catch (QuestionException e) {
					new Alert(myActivity, "Não foi possivel Adicionar questões a atividade.",
							"Fechar", Alert.ARCHER_AMAZED).show();				
				} catch (LessonException e) {
					new Alert(myActivity, "Não foi possivel atualizar.",
							"Fechar", Alert.ARCHER_AMAZED).show();
				}
			}
		});

	}
	
	@Override
	protected void onDestroy() {
	    super.onDestroy();
		DatabaseConnection.closeDatabase();
	}

}
