package br.com.ufpb.question;

import java.util.ArrayList;
import java.util.List;

public class QuestionsControl {

	private List<Question> questions;
	private static QuestionsControl questionsControl;

	private QuestionsControl() {
		questions = new ArrayList<Question>();
		this.bearsQuestions();
	}

	public void addQuestion(Question question)
			throws QuestionException {		

		for (Question q : questions) {
			if (q.getId() == question.getId()) {
				throw new QuestionException("id already exists.");
			}
		}

		questions.add(question);
	}

	public Question generateQuestion() throws QuestionException {
		Question question = questions.get((int) (Math.random() * questions
				.size()));
		if (question == null) {
			throw new QuestionException("There are no questions.");
		}
		return question;
	}
	
	public Question getQuestion(int index){
		return questions.get(index);
	}

	public static QuestionsControl getInstance() {
		if (questionsControl == null) {
			questionsControl = new QuestionsControl();
		}
		return questionsControl;

	}

	private void bearsQuestions() {
		
		try{
		
		Question question = new Question(0,	"1.	O clima de uma região depende "
				+ "de sua localização na terra. A temperatura também. "
				+ "Qual das temperaturas abaixo é negativa, ou seja, menor que zero?",
				"-15°C");
		question.addIncorrectAnswer("10°C");
		question.addIncorrectAnswer("100°C");
		question.addIncorrectAnswer("150°C");
		question.addIncorrectAnswer("15°C");
		
		addQuestion(question);
		
		question = new Question(1,	"2.	O que significa dizer que um mergulhador está a "
				+ "12 metros abaixo do nível do mar, utilizando a matemática?",
				"-12 m");
		question.addIncorrectAnswer("12 m");
		question.addIncorrectAnswer("10 m");
		question.addIncorrectAnswer("1 m");
		question.addIncorrectAnswer("5 m");
		
		addQuestion(question);
		
		question = new Question(2,	"3.	O banco em que Antônio é cliente avisou que ele "
				+ "estava devendo 148,00. Isso significa que no extrato bancário apareceu?",
				"-148,00");
		question.addIncorrectAnswer("-100,00");
		question.addIncorrectAnswer("100,00");
		question.addIncorrectAnswer("10,00");
		question.addIncorrectAnswer("-14,00");		
		
		addQuestion(question);
		
		question = new Question(3,	"4.	O ponto mais alto do Brasil é o Pico da Neblina, que "
				+ "tem 2.994 metros de altitude. Indique essa altitude usando um número inteiro "
				+ "positivo ou negativo",
				"+2.994");
		question.addIncorrectAnswer("2,994");
		question.addIncorrectAnswer("+7.33");
		question.addIncorrectAnswer("+29940");
		question.addIncorrectAnswer("+055");		
		
		addQuestion(question);
		
		question = new Question(4,	"5.	-18ºC é uma temperatura abaixo de 0ºC. Encontre agora uma "
				+ "temperatura acima de 0ºC",
				"11°");
		question.addIncorrectAnswer("-11");
		question.addIncorrectAnswer("-18°");
		question.addIncorrectAnswer("0°");
		question.addIncorrectAnswer("-1°");		
		
		addQuestion(question);
		
		question = new Question(5,	"6.	O que significa dever R$100,00?",
				"R$ -100");
		question.addIncorrectAnswer("R$ 100");
		question.addIncorrectAnswer("R$ 110");
		question.addIncorrectAnswer("R$ -10");
		question.addIncorrectAnswer("R$ 0");		
		
		addQuestion(question);
		
		question = new Question(6,	"7.	O que corresponde a 11 andares acima do andar térreo?",
				"+11");
		question.addIncorrectAnswer("+12");
		question.addIncorrectAnswer("-11");
		question.addIncorrectAnswer("-10");
		question.addIncorrectAnswer("0");		
		
		addQuestion(question);
		
		question = new Question(7,	"8.	Pedro não tem nenhum valor em sua conta bancária significa que seu saldo está?",
				"0 (Zero)");
		question.addIncorrectAnswer("1");
		question.addIncorrectAnswer("-1");
		question.addIncorrectAnswer("-5");
		question.addIncorrectAnswer("5");		
		
		addQuestion(question);
		
		question = new Question(8,	"9.	Em uma reta numérica verifique qual dos números, está mais distante da origem?",
				"10");
		question.addIncorrectAnswer("0");
		question.addIncorrectAnswer("1");
		question.addIncorrectAnswer("-1");
		question.addIncorrectAnswer("5");		
		
		addQuestion(question);
		
		question = new Question(9,	"10. Quem está mais próximo do zero em uma reta numérica  de -4 a 8?",
				"-1");
		question.addIncorrectAnswer("-4");
		question.addIncorrectAnswer("2");
		question.addIncorrectAnswer("8");
		question.addIncorrectAnswer("5");		
		
		addQuestion(question);
		
		question = new Question(10,	"11. Em uma reta numérica, qual a distância do número -6 em relação ao zero?",
				"6");
		question.addIncorrectAnswer("1");
		question.addIncorrectAnswer("0");
		question.addIncorrectAnswer("-6");
		question.addIncorrectAnswer("4");		
		
		addQuestion(question);
		
		question = new Question(11,	"12. Observe a listagem de números inteiros: -1,-3,-5,-7,-9. Que número seria o próximo?",
				"-11");
		question.addIncorrectAnswer("-12");
		question.addIncorrectAnswer("-10");
		question.addIncorrectAnswer("-9");
		question.addIncorrectAnswer("11");		
		
		addQuestion(question);
		
		question = new Question(12,	"13. Agora observe: -1,+1,-2,+2,-3. Qual o próximo?",
				"+3");
		question.addIncorrectAnswer("-4");
		question.addIncorrectAnswer("-3");
		question.addIncorrectAnswer("+4");
		question.addIncorrectAnswer("+7");		
		
		addQuestion(question);
		
		
		question = new Question(13,	"14. Utilizando a reta numérica verifique qual o número simétrico ou oposto de 4?",
				"-4");
		question.addIncorrectAnswer("-3");
		question.addIncorrectAnswer("-2");
		question.addIncorrectAnswer("-2");
		question.addIncorrectAnswer("5");		
		
		addQuestion(question);
		
		question = new Question(14,	"15. Qual o simétrico ou oposto de -20?",
				"20");
		question.addIncorrectAnswer("-20");
		question.addIncorrectAnswer("-21");
		question.addIncorrectAnswer("2");
		question.addIncorrectAnswer("0");		
		
		addQuestion(question);	
		
		question = new Question(15,	"16. Encontre um par de números simétricos.",
				"(8,-8)");
		question.addIncorrectAnswer("(2,-7)");
		question.addIncorrectAnswer("(3,-9)");
		question.addIncorrectAnswer("(4,-8)");
		question.addIncorrectAnswer("(5,-2)");		
		
		addQuestion(question);	
		
		question = new Question(16,	"17. Ainda utilizando a reta numérica, verifique qual é o antecessor de -4?",
				"-5");
		question.addIncorrectAnswer("-3");
		question.addIncorrectAnswer("-2");
		question.addIncorrectAnswer("5");
		question.addIncorrectAnswer("0");		
		
		addQuestion(question);	
		
		question = new Question(17,	"18. Qual o sucessor de -2?",
				"-1");
		question.addIncorrectAnswer("-3");
		question.addIncorrectAnswer("2");
		question.addIncorrectAnswer("3");
		question.addIncorrectAnswer("-2");		
		
		addQuestion(question);	
		
		question = new Question(18,	"19. Qual número inteiro está entre -3 e -1?",
				"-2");
		question.addIncorrectAnswer("-3");
		question.addIncorrectAnswer("2");
		question.addIncorrectAnswer("-1");
		question.addIncorrectAnswer("-2");		
		
		addQuestion(question);	
		
		question = new Question(19,	"20. Indique um número maior que -9?",
				"0");
		question.addIncorrectAnswer("-3");
		question.addIncorrectAnswer("-20");
		question.addIncorrectAnswer("-11");
		question.addIncorrectAnswer("-10");		
		
		addQuestion(question);
		
		question = new Question(20,	"21. Resolva: -3+7,  -5+1  e  4- 9.",
				"4, -4 e -5");
		question.addIncorrectAnswer("4, -4 e -5");
		question.addIncorrectAnswer("5, -2 e -5");
		question.addIncorrectAnswer("5, -2 e -4");
		question.addIncorrectAnswer("4, -2 e -5");		
		
		addQuestion(question);
		
		question = new Question(21,	"22. Qual é o resultado de: 20-23+5-2+4+7?",
				"11");
		question.addIncorrectAnswer("-11");
		question.addIncorrectAnswer("12");
		question.addIncorrectAnswer("13");
		question.addIncorrectAnswer("10");		
		
		addQuestion(question);
		
		question = new Question(22,	"23. O resultado de 10-3+20-30 é?",
				"-3");
		question.addIncorrectAnswer("11");
		question.addIncorrectAnswer("-4");
		question.addIncorrectAnswer("5");
		question.addIncorrectAnswer("4");		
		
		addQuestion(question);
		
		question = new Question(23,	"24. Laura tinha R$200,00 em sua conta bancária, na segunda-feira. Ela fez um saque de R$125,00 e depositou um cheque de R$100,00. Qual a expressão que melhor representa o que aconteceu com a conta dela?",
				"185");
		question.addIncorrectAnswer("-185");
		question.addIncorrectAnswer("100");
		question.addIncorrectAnswer("200");
		question.addIncorrectAnswer("-200");		
		
		addQuestion(question);
		
		question = new Question(24,	"25. Um certo prédio tem vários andares inclusive o subsolo. O elevador apresenta botões de -3 a 10 para cada andar. O térreo é considerado o andar zero. Um elevador que estava no 5º andar desceu 7 andares. Em que andar ele se encontra?",
				"-2");
		question.addIncorrectAnswer("2");
		question.addIncorrectAnswer("-4");
		question.addIncorrectAnswer("5");
		question.addIncorrectAnswer("4");		
		
		addQuestion(question);
		
		question = new Question(25,	"26. Um elevador apresenta botões de -3 a 10 para cada andar. O térreo é considerado o andar zero.Ele  estava no 3º andar, subiu 2 andares e desceu 5. Em que andar ele está?",
				"0");
		question.addIncorrectAnswer("-2");
		question.addIncorrectAnswer("-4");
		question.addIncorrectAnswer("9");
		question.addIncorrectAnswer("3");		
		
		addQuestion(question);
		
		question = new Question(26,	"27. Um elevador apresenta botões de -3 a 10 para cada andar. O térreo é considerado o andar zero. Ele estava no térreo, desceu dois andares, parou e, em seguida, desceu outro andar. Em que andar ele se encontra?",
				"-3");
		question.addIncorrectAnswer("-9");
		question.addIncorrectAnswer("-4");
		question.addIncorrectAnswer("3");
		question.addIncorrectAnswer("7");		
		
		addQuestion(question);
			
		} catch (QuestionException e) {
			e.printStackTrace();
		}
	}

}
