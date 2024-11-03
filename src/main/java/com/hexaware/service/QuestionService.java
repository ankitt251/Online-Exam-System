package com.hexaware.service;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.QuestionDao;
import com.hexaware.model.Question;

public class QuestionService {
	static Scanner scan = new Scanner(System.in);
	QuestionDao questionDao = new QuestionDao();
	int score = 0;

	public void addQuestions() {
		System.out.println("Question Number: ");
		int questionNum = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Question: ");
		String question = scan.nextLine();
		System.out.println("Enter Option A: ");
		String optionA = scan.nextLine();
		System.out.println("Enter Option B: ");
		String optionB = scan.nextLine();
		System.out.println("Enter Option C: ");
		String optionC = scan.nextLine();
		System.out.println("Enter Option D: ");
		String optionD = scan.nextLine();
		System.out.println("Enter Answer: ");
		String answer = scan.nextLine();
		Question que = new Question(questionNum, question, optionA, optionB, optionC, optionD, answer);
		questionDao.addQuestions(que);
		System.out.println("Question added successfully!");
	}

	public void updateQuestions() {
		System.out.println("Enter Question Number: ");
		int questionNum = scan.nextInt();
		scan.nextLine();

		Question updateQue = questionDao.getQuestionByNum(questionNum);
		if (updateQue != null) {
			System.out.println("Update Question: ");
			String question = scan.nextLine();
			System.out.println("Update Option A: ");
			String optionA = scan.nextLine();
			System.out.println("Update Option B: ");
			String optionB = scan.nextLine();
			System.out.println("Update Option C: ");
			String optionC = scan.nextLine();
			System.out.println("Update Option D: ");
			String optionD = scan.nextLine();
			System.out.println("Update Answer: ");
			String answer = scan.nextLine();

			updateQue.setQuestionText(question);
			updateQue.setOptionA(optionA);
			updateQue.setOptionB(optionB);
			updateQue.setOptionC(optionC);
			updateQue.setOptionD(optionD);
			updateQue.setCorrectAnswer(answer);
			questionDao.updateQuestions(updateQue);
			System.out.println("Question updated successfully!");
		} else {
			System.out.println("Question not found!");
		}
	}

	public void deleteQuestions() {
		System.out.println("Enter Question Number: ");
		int questionNum = scan.nextInt();
		scan.nextLine();
		questionDao.getQuestionByNum(questionNum);
		questionDao.deleteQuestions(questionNum);
		System.out.println("Question deleted successfully!");
	}

	public void viewAllQue() {
		List<Question> que = questionDao.getAllQuestions();

		if (que.isEmpty()) {
			System.out.println("No questions found!");
		} else {
			for (Question ques : que) {
				System.out.println("Question: " + ques.getQuestionText());
				// System.out.println(question);
			}
		}
	}

	public void takeExam() {
		List<Question> que = questionDao.getAllQuestions();

		if (que.isEmpty()) {
			System.out.println("No questions found!");
		}

		score = 0;

		System.out.println("Starting the exam. Answer the following questions:");

		for (Question question : que) {
			System.out.println("Question Number: " + question.getQuestionNum() + ":");
			System.out.println("Question: " + question.getQuestionText());
			System.out.println("A. " + question.getOptionA());
			System.out.println("B. " + question.getOptionB());
			System.out.println("C. " + question.getOptionC());
			System.out.println("D. " + question.getOptionD());
			System.out.print("Enter your answer: ");
			String answer = scan.nextLine();
			scan.nextLine();
			if (answer.equals(question.getCorrectAnswer().toUpperCase())) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect!");
			}
			System.out.println();
			displayResult(que.size());
		}
	}

	private void displayResult(int totalQuestions) {
		System.out.println("Exam finished!");
		System.out.println("Your score: " + score + " out of " + totalQuestions);
	}
}
