package br.com.ufpb.lesson;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import br.com.ufpb.question.Question;
import br.com.ufpb.question.QuestionC;
import br.com.ufpb.question.QuestionException;
import br.com.ufpb.util.DatabaseConnection;

public class LessonControl {

	private SQLiteStatement statement;
	private QuestionC questionControl;
	private static final String INSERT = "INSERT INTO LESSON (ID, NAME, HELP) values (?, ?, ?)";
	private static final String UPDATE = "UPDATE LESSON SET NAME = ? , HELP = ? where id = ?";

	public LessonControl(Context context) {
		DatabaseConnection.getInstance(context);
		this.questionControl = new QuestionC(context);
	}

	public void addLesson(Lesson lesson) throws LessonException,
			QuestionException {
		this.statement = DatabaseConnection.getDb().compileStatement(INSERT);
		this.statement.bindDouble(1, lesson.getId());
		this.statement.bindString(2, lesson.getName());
		this.statement.bindString(3, lesson.getHelp());
		this.statement.executeInsert();
		this.addLessonQuestions(lesson);
	}

	public void updateLesson(Lesson lesson) throws LessonException,
			QuestionException {
		this.statement = DatabaseConnection.getDb().compileStatement(UPDATE);
		this.statement.bindString(1, lesson.getName());
		this.statement.bindString(2, lesson.getHelp());
		this.statement.bindDouble(3, lesson.getId());
		this.statement.executeInsert();
		this.questionControl.deleteQuestionLessons(lesson.getId());
		this.addLessonQuestions(lesson);
	}

	public List<Lesson> getLesson() {
		Lesson lesson;
		List<Lesson> lessons = new ArrayList<Lesson>();
		Cursor cursor = DatabaseConnection.getDb().query("LESSON",
				new String[] { "ID", "NAME", "HELP" }, null, null, null, null,
				"NAME");

		if (cursor.moveToFirst()) {
			do {
				lesson = new Lesson();
				lesson.setId(cursor.getInt(cursor.getColumnIndex("ID")));
				lesson.setName(cursor.getString(cursor.getColumnIndex("NAME")));
				lesson.setHelp(cursor.getString(cursor.getColumnIndex("HELP")));
				lesson.setQuestions(this.questionControl
					.getFindQuestionLesson(lesson.getId()));
				lessons.add(lesson);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return lessons;
	}

	private void addLessonQuestions(Lesson lesson) throws QuestionException {
		for (Question q : lesson.getQuestions()) {
			q.setActivity_id(lesson.getId());
			this.questionControl.addQuestion(q);
		}
	}

}
