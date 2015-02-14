package br.com.ufpb.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.util.Log;
import br.com.ufpb.lesson.Lesson;
import br.com.ufpb.lesson.LessonControl;
import br.com.ufpb.lesson.LessonException;
import br.com.ufpb.question.QuestionException;
import br.com.ufpb.servico.HttpClientConnection;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class UpdateDatabase {
	
	private static final String URL = "http://matharrow.esy.es/servico/atividade/BeanAtividade.php";
	private Gson gson;
	private JsonParser parser;
	private List<Lesson> lessons;
	private LessonControl lessonControl;
	private ArrayList<NameValuePair> parametros;

	public UpdateDatabase(Context context) {
		this.gson = new Gson();
		this.parser = new JsonParser();
		this.lessonControl = new LessonControl(context);
	}

	private List<Lesson> getLesson(String codigo) {
		lessons = new ArrayList<Lesson>();
		parametros = new ArrayList<NameValuePair>();
		parametros.add(new BasicNameValuePair("action","query_atividade_mobile"));
		parametros.add(new BasicNameValuePair("codigo", codigo));
		try {
			String respostaRetornada = HttpClientConnection.executaHttpPost(URL,
					parametros);
			String resposta = respostaRetornada.toString();
			JsonArray array = parser.parse(resposta).getAsJsonArray();

			try {
				for (int i = 0; i < array.size(); i++) {
					Lesson lesson = gson.fromJson(array.get(i), Lesson.class);
					Log.i("Resposta L",lesson.getQuestions().get(0).toString());
					lessons.add(lesson);
				}
			} catch (Exception e) {
				Log.i("ERRO ATIVIDADE", e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("ERRO NÃO DEU CERTO " + e.getMessage());
		} 
		return lessons;
	}	
	
	public void updateLesson(String codigo) throws LessonException, QuestionException {
		for (Lesson lesson : getLesson(codigo)) {
			boolean cond = true;
			for (Lesson lessonDB : lessonControl.getLesson()) {
				if(lesson.getId() == lessonDB.getId()){
                    if(!lesson.toString().equalsIgnoreCase(lessonDB.toString())){                            
                    	lessonControl.updateLesson(lesson);
                    }
                    cond = false;
                }                    
            }    
            if(cond){
            	lessonControl.addLesson(lesson);
            }
		}
	}
}
