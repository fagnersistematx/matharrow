package br.com.ufpb.question;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import br.com.ufpb.util.DatabaseConnection;

public class AnswerControl {
	
	private SQLiteStatement statement;
	private static final String INSERT_ANSWER = "INSERT INTO ANSWERRR (QUESTION_ID, ANSWER_I) values (?, ?)";	
	
	public AnswerControl(Context context) {
		DatabaseConnection.getInstance(context);
	}

	public void addAnswer(Question question, String answer) {
		this.statement = DatabaseConnection.getDb().compileStatement(INSERT_ANSWER);
		this.statement.bindDouble(1, question.getId());
		this.statement.bindString(2, answer);
		this.statement.executeInsert();
	}
		
	public List<String> getFindAnswerQuestion(int id) {	
		List<String> answers = new ArrayList<String>();		
		
		Cursor cursor = DatabaseConnection.getDb().query("ANSWERRR",
				new String[] {"QUESTION_ID", "ANSWER_I"},
				"QUESTION_ID = ?", new String[] { "" + id }, null, null, "ANSWER_I");
		
		if (cursor.moveToFirst()) {
			do {				
				answers.add(cursor.getString(cursor
						.getColumnIndex("ANSWER_I")));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return answers;
	}

}
