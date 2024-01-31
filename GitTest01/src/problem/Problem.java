package problem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import problemDAO.ProblemDAO;
import questionDTO.QuestionDTO;

public class Problem {
	    Scanner sc = new Scanner(System.in);
	    ProblemDAO  pdao = new ProblemDAO();
//		ArrayList<String> Q_height = new ArrayList<String>(10);
//		ArrayList<String> Q_middle = new ArrayList<String>(10);
//		ArrayList<String> Q_lowness = new ArrayList<String>(10);
		String answer;
		
		
		// 생성자 
//		public Problem() {
//			
//			
//		}



		// 문제 푸는 메서드
		public String solution() {
			System.out.println("문제 나이도 선택해 주세요. [1]: easy, [2]: normal, [3]: hard ");
			int choice = sc.nextInt();
			// 문제 번호 랜덤으로 생성됨.
			Random rd = new Random();
			int num = rd.nextInt(20);
			
			// db에서 선택한 문제 가져오기.
			
			QuestionDTO Question = null; // db에서 가져온 문제를 담는 객체야.
			switch(choice) {
				case 1: 
					Question = pdao.searchProblem("easy", num); // db에서 사용자가 선택한 문제 가져온다.
					break;
				case 2:
					Question = pdao.searchProblem("normal", num); // db에서 사용자가 선택한 문제 가져온다.
					break;
				case 3:
					Question = pdao.searchProblem("hard", num); // db에서 사용자가 선택한 문제 가져온다.
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
			}
			
			System.out.println("문제 :" + Question.getNumber()+ "번호 : " + Question.getQuestion());
			
		
			System.out.print("정답을 입력해 주세요.  :");
			answer =  sc.next();
			
			// db에서 정답 가져오는 메소드 호출해서 비교 해줄꺼야.
			
			return answer;
		}

}