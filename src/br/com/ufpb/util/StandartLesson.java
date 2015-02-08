package br.com.ufpb.util;

import java.util.ArrayList;

import android.app.Activity;
import br.com.ufpb.lesson.Lesson;
import br.com.ufpb.lesson.LessonControl;
import br.com.ufpb.lesson.LessonException;
import br.com.ufpb.question.Question;
import br.com.ufpb.question.QuestionException;

public class StandartLesson implements Runnable {

	private LessonControl lessonControl;
	private Lesson lesson;

	public StandartLesson(Activity activity) {
		this.lessonControl = new LessonControl(activity);
		lesson = new Lesson();
	}

	@Override
	public void run() {
		if (lessonControl.getLesson().size() <= 0) {
			try {

				lesson = new Lesson();
				lesson.setId(1);
				lesson.setName("Números Inteiros");
				lesson.setHelp("Os números inteiros são constituídos dos números naturais.");
				lesson.setQuestions(new ArrayList<Question>());
				bearsQuestions();
				lessonControl.addLesson(lesson);

			} catch (LessonException e) {
				e.printStackTrace();
			} catch (QuestionException e) {
				e.printStackTrace();
			}
		}

	}

	private void bearsQuestions() {

		try {

			Question question = new Question(
					0,
					"1.	O clima de uma região depende "
							+ "de sua localização na terra. A temperatura também. "
							+ "Qual das temperaturas abaixo é negativa, ou seja, menor que zero?",
					"-15°C");
			question.addIncorrectAnswer("10°C");
			question.addIncorrectAnswer("100°C");
			question.addIncorrectAnswer("150°C");
			question.addIncorrectAnswer("15°C");

			lesson.getQuestions().add(question);

			question = new Question(
					1,
					"1.	O que significa dizer que um mergulhador está a "
							+ "12 metros abaixo do nível do mar, utilizando a matemática?",
					"-12 m");
			question.addIncorrectAnswer("12 m");
			question.addIncorrectAnswer("10 m");
			question.addIncorrectAnswer("1 m");
			question.addIncorrectAnswer("5 m");

			lesson.getQuestions().add(question);

			question = new Question(
					2,
					"2.	O banco em que Antônio é cliente avisou que ele "
							+ "estava devendo 148,00. Isso significa que no extrato bancário apareceu?",
					"-148,00");
			question.addIncorrectAnswer("-100,00");
			question.addIncorrectAnswer("100,00");
			question.addIncorrectAnswer("10,00");
			question.addIncorrectAnswer("-14,00");

			lesson.getQuestions().add(question);

			question = new Question(3,
					"3.	-18ºC é uma temperatura abaixo de 0ºC. Encontre agora uma "
							+ "temperatura acima de 0ºC", "11°");
			question.addIncorrectAnswer("-11");
			question.addIncorrectAnswer("-18°");
			question.addIncorrectAnswer("0°");
			question.addIncorrectAnswer("-1°");

			lesson.getQuestions().add(question);

			question = new Question(4,
					"4.	O que corresponde a 11 andares acima do andar térreo?",
					"+11");
			question.addIncorrectAnswer("+12");
			question.addIncorrectAnswer("-11");
			question.addIncorrectAnswer("-10");
			question.addIncorrectAnswer("0");

			lesson.getQuestions().add(question);

			question = new Question(
					5,
					"5.	Pedro não tem nenhum valor em sua conta bancária significa que seu saldo está?",
					"0 (Zero)");
			question.addIncorrectAnswer("1");
			question.addIncorrectAnswer("-1");
			question.addIncorrectAnswer("-5");
			question.addIncorrectAnswer("5");

			lesson.getQuestions().add(question);

			question = new Question(
					6,
					"6.	Em uma reta numérica verifique qual dos números, está mais distante da origem?",
					"10");
			question.addIncorrectAnswer("0");
			question.addIncorrectAnswer("1");
			question.addIncorrectAnswer("-1");
			question.addIncorrectAnswer("5");

			lesson.getQuestions().add(question);

			question = new Question(
					7,
					"7. Quem está mais próximo do zero em uma reta numérica  de -4 a 8?",
					"-1");
			question.addIncorrectAnswer("-4");
			question.addIncorrectAnswer("2");
			question.addIncorrectAnswer("8");
			question.addIncorrectAnswer("5");

			lesson.getQuestions().add(question);

			question = new Question(
					8,
					"8. Em uma reta numérica, qual a distância do número -6 em relação ao zero?",
					"6");
			question.addIncorrectAnswer("1");
			question.addIncorrectAnswer("0");
			question.addIncorrectAnswer("-6");
			question.addIncorrectAnswer("4");

			lesson.getQuestions().add(question);

			question = new Question(
					9,
					"9. Observe a listagem de números inteiros: -1,-3,-5,-7,-9. Que número seria o próximo?",
					"-11");
			question.addIncorrectAnswer("-12");
			question.addIncorrectAnswer("-10");
			question.addIncorrectAnswer("-9");
			question.addIncorrectAnswer("11");

			lesson.getQuestions().add(question);

			question = new Question(10,
					"10. Agora observe: -1,+1,-2,+2,-3. Qual o próximo?", "+3");
			question.addIncorrectAnswer("-4");
			question.addIncorrectAnswer("-3");
			question.addIncorrectAnswer("+4");
			question.addIncorrectAnswer("+7");

			lesson.getQuestions().add(question);

			question = new Question(
					11,
					"11. Utilizando a reta numérica verifique qual o número simétrico ou oposto de 4?",
					"-4");
			question.addIncorrectAnswer("-3");
			question.addIncorrectAnswer("-2");
			question.addIncorrectAnswer("-2");
			question.addIncorrectAnswer("5");

			lesson.getQuestions().add(question);

			question = new Question(12,
					"12. Encontre um par de números simétricos.", "(8,-8)");
			question.addIncorrectAnswer("(2,-7)");
			question.addIncorrectAnswer("(3,-9)");
			question.addIncorrectAnswer("(4,-8)");
			question.addIncorrectAnswer("(5,-2)");

			lesson.getQuestions().add(question);

			question = new Question(13, "13. Qual o sucessor de -2?", "-1");
			question.addIncorrectAnswer("-3");
			question.addIncorrectAnswer("2");
			question.addIncorrectAnswer("3");
			question.addIncorrectAnswer("-2");

			lesson.getQuestions().add(question);

			question = new Question(14, "14. Indique um número maior que -9?",
					"0");
			question.addIncorrectAnswer("-3");
			question.addIncorrectAnswer("-20");
			question.addIncorrectAnswer("-11");
			question.addIncorrectAnswer("-10");

			lesson.getQuestions().add(question);

			question = new Question(15, "15. Resolva: -3+7,  -5+1  e  4- 9.",
					"4, -4 e -5");
			question.addIncorrectAnswer("4, -4 e -5");
			question.addIncorrectAnswer("5, -2 e -5");
			question.addIncorrectAnswer("5, -2 e -4");
			question.addIncorrectAnswer("4, -2 e -5");

			lesson.getQuestions().add(question);

			question = new Question(16,
					"16. Qual é o resultado de: 20-23+5-2+4+7?", "11");
			question.addIncorrectAnswer("-11");
			question.addIncorrectAnswer("12");
			question.addIncorrectAnswer("13");
			question.addIncorrectAnswer("10");

			lesson.getQuestions().add(question);

			question = new Question(17, "17. O resultado de 10-3+20-30 é?",
					"-3");
			question.addIncorrectAnswer("11");
			question.addIncorrectAnswer("-4");
			question.addIncorrectAnswer("5");
			question.addIncorrectAnswer("4");

			lesson.getQuestions().add(question);

			question = new Question(
					18,
					"18. Laura tinha R$200,00 em sua conta bancária, na segunda-feira. Ela fez um saque de R$125,00 e depositou um cheque de R$100,00. Qual a expressão que melhor representa o que aconteceu com a conta dela?",
					"185");
			question.addIncorrectAnswer("-185");
			question.addIncorrectAnswer("100");
			question.addIncorrectAnswer("200");
			question.addIncorrectAnswer("-200");

			lesson.getQuestions().add(question);

			question = new Question(
					19,
					"19. Um certo prédio tem vários andares inclusive o subsolo. O elevador apresenta botões de -3 a 10 para cada andar. O térreo é considerado o andar zero. Um elevador que estava no 5º andar desceu 7 andares. Em que andar ele se encontra?",
					"-2");
			question.addIncorrectAnswer("2");
			question.addIncorrectAnswer("-4");
			question.addIncorrectAnswer("5");
			question.addIncorrectAnswer("4");

			lesson.getQuestions().add(question);

			question = new Question(
					20,
					"20. Um elevador apresenta botões de -3 a 10 para cada andar. O térreo é considerado o andar zero. Ele estava no térreo, desceu dois andares, parou e, em seguida, desceu outro andar. Em que andar ele se encontra?",
					"-3");
			question.addIncorrectAnswer("-9");
			question.addIncorrectAnswer("-4");
			question.addIncorrectAnswer("3");
			question.addIncorrectAnswer("7");

			lesson.getQuestions().add(question);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
