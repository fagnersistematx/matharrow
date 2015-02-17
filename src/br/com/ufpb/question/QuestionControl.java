package br.com.ufpb.question;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import br.com.ufpb.util.DatabaseConnection;

public class QuestionControl {

	private SQLiteStatement statement;
	private AnswerControl answerControl;
	private static final String INSERT = "INSERT INTO QUESTION (ID, ACTIVITY_ID, QUESTION, ANSWER) values (?, ?, ?, ?)";	
	private static final String UPDATE = "UPDATE LESSON SET QUESTION = ? , ANSWER = ? WHERE ID = ?";
	private static final String DELETE = "DELETE FROM QUESTION WHERE ID = ?";
	private static final String DELETE_LESSON = "DELETE FROM QUESTION WHERE ACTIVITY_ID = ?";

	public QuestionControl(Context context) {
		DatabaseConnection.getInstance(context);
		answerControl = new AnswerControl(context);
	}

	public void addQuestion(Question question) throws QuestionException {
		this.statement = DatabaseConnection.getDb().compileStatement(INSERT);
		this.statement.bindDouble(1, question.getId());
		this.statement.bindDouble(2, question.getActivity_id());
		this.statement.bindString(3, question.getQuestion());
		this.statement.bindString(4, question.getAnswer());
		this.statement.executeInsert();
		addIncorrectAnswers(question);
	}

	private void addIncorrectAnswers(Question question) {
		for (String answer : question.getIncorrectAnswer()) {
			answerControl.addAnswer(question, answer);
		}		
	}	

	public void updateQuestion(Question question) {
		this.statement = DatabaseConnection.getDb().compileStatement(UPDATE);
		this.statement.bindString(1, question.getQuestion());
		this.statement.bindString(2, question.getAnswer());
		this.statement.bindDouble(3, question.getId());
		this.statement.executeInsert();
	}

	public void deleteQuestion(int id) {
		this.statement = DatabaseConnection.getDb().compileStatement(DELETE);
		this.statement.bindDouble(1, id);
		this.statement.executeInsert();
	}

	/**
	 * 
	 * @param id
	 *            Lesson id
	 */
	public void deleteQuestionLessons(int id) {
		this.statement = DatabaseConnection.getDb().compileStatement(
				DELETE_LESSON);
		this.statement.bindDouble(1, id);
		this.statement.executeInsert();
	}

	public List<Question> getQuestions() {
		Question question;
		List<Question> questions = new ArrayList<Question>();
		Cursor cursor = DatabaseConnection.getDb().query("QUESTION",
				new String[] { "ID", "ACTIVITY_ID", "QUESTION", "ANSWER" },
				null, null, null, null, "ID");

		if (cursor.moveToFirst()) {
			do {
				question = new Question();
				question.setId(cursor.getInt(cursor.getColumnIndex("ID")));
				question.setActivity_id(cursor.getInt(cursor
						.getColumnIndex("ACTIVITY_ID")));
				question.setQuestion(cursor.getString(cursor
						.getColumnIndex("QUESTION")));
				question.setAnswer(cursor.getString(cursor
						.getColumnIndex("ANSWER")));
				
				question.setIncorrectAnswer(answerControl.getFindAnswerQuestion(question.getId()));
				
				questions.add(question);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return questions;
	}

	public List<Question> getFindQuestionLesson(int id) {
		Question question;
		List<Question> questions = new ArrayList<Question>();
		Cursor cursor = DatabaseConnection.getDb().query("QUESTION",
				new String[] { "ID", "ACTIVITY_ID", "QUESTION", "ANSWER" },
				"ACTIVITY_ID = ?", new String[] { "" + id }, null, null, "ID");

		if (cursor.moveToFirst()) {
			do {
				question = new Question();
				question.setId(cursor.getInt(cursor.getColumnIndex("ID")));
				question.setActivity_id(cursor.getInt(cursor
						.getColumnIndex("ACTIVITY_ID")));
				question.setQuestion(cursor.getString(cursor
						.getColumnIndex("QUESTION")));
				question.setAnswer(cursor.getString(cursor
						.getColumnIndex("ANSWER")));
				
				question.setIncorrectAnswer(answerControl.getFindAnswerQuestion(question.getId()));
				
				questions.add(question);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return questions;
	}

	public Question getFind(int id) {
		Question question = null;
		Cursor cursor = DatabaseConnection.getDb().query("QUESTION",
				new String[] { "ID", "ACTIVITY_ID", "QUESTION", "ANSWER" },
				"ID = ?", new String[] { "" + id }, null, null, "ID");

		if (cursor.moveToFirst()) {
			do {
				question = new Question();
				question.setId(cursor.getInt(cursor.getColumnIndex("ID")));
				question.setActivity_id(cursor.getInt(cursor
						.getColumnIndex("ACTIVITY_ID")));
				question.setQuestion(cursor.getString(cursor
						.getColumnIndex("QUESTION")));
				question.setAnswer(cursor.getString(cursor
						.getColumnIndex("ANSWER")));
				
				question.setIncorrectAnswer(answerControl.getFindAnswerQuestion(question.getId()));

				cursor.close();

				return question;
			} while (cursor.moveToNext());
		}
		return question;
	}	

}
