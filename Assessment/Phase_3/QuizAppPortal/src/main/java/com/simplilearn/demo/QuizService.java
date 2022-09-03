package com.simplilearn.demo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService<questionsid> {
	
	@Autowired
	private QuizRepo repo;
	
	public List<Quiz> findque(int quizid) {
		List<Quiz> questionss = repo.findByQuizid(quizid);
		return questionss;
	}
	
	
	
	

	
	

	
	
	

}