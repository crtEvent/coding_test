package com.codingtest.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P036_잃어버린 괄호(최솟값을 만드는 괄호배치 찾기)
 * Q. 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 괄호를 재배치하여 이 수식의 값을 최소로 만드는 프로그램을 작성하라
 *  - 식은 '0'~'9', '+', '-'만으로 이루어 짐
 *  - 처음과 마지막 문자는 숫자
 *  - 수는 0으로 시작할 수 있다
 * @author : crtEvent
 * @date   : 2022. 11. 29.
 */
public class P036_MissingParenthesis {
	
	public static void runPrompt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수식을 입력하세요. 예)100-40+50+74-30+29-45+43+11");
		String expression = sc.nextLine();
		
		getMinimumPlacement(expression);
		
		sc.close();
	}
	
	public static void getMinimumPlacement(String expression) {
		runMysolution(expression);
		//runSolution(expression);
	}
	
	/* 최솟값을 만들기 위해서 가능한 가장 큰 수를 빼야 한다 */
	public static void runMysolution(String expression) {
		String[] expGroups = expression.split("\\-");
		System.out.println("expGroups: "+Arrays.toString(expGroups));
		
		// 더하기 연산
		int[] numGroups = new int[expGroups.length];
		for(int i = 0; i < expGroups.length; i++) {
			String[] plusGroups =  expGroups[i].split("\\+");
			for(int j = 0; j < plusGroups.length; j++) {
				numGroups[i] += Integer.parseInt(plusGroups[j]);
			}
		}
		System.out.println("numGroups: "+Arrays.toString(numGroups));
		
		// 빼기 연산
		int sum = numGroups[0];
		for(int i = 1; i < numGroups.length; i++) {
			sum -= numGroups[i];
		}
		
		// 변경된 수식 출력
		printExpression(expGroups);
		printExpression(numGroups);
		System.out.println("최솟값: "+sum);
	}
	
	public static void printExpression(int[] numGroups) {
		System.out.print("수식: ["+numGroups[0]);
		for(int i = 1; i < numGroups.length; i++) {
			System.out.print("-"+ numGroups[i]);
		}
		System.out.print("]\n");
	}
	
	public static void printExpression(String[] expGroups) {
		System.out.print("수식: ["+expGroups[0]);
		for(int i = 1; i < expGroups.length; i++) {
			System.out.print("-("+ expGroups[i]+")");
		}
		System.out.print("]\n");
	}
	
	public static void runSolution(String expression) {
		int answer = 0;
		String[] expGroups = expression.split("\\-");
		for(int i = 0; i < expGroups.length; i++) {
			int temp = mySum(expGroups[i]);
			if(i == 0) {
				answer += temp; // 가장 앞에 있는 값만 더함
			} else {
				answer -= temp; // 뒷 부분은 빼기 연산
			}
		}
		System.out.println("최솟값: "+answer);
	}
	
	// 나뉜 그룹의 더하기 연산 수행 함수
	public static int mySum(String a) {
		int sum = 0;
		String[] temp = a.split("[+]");
		for(int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}

	public static void main(String[] args) {
		runPrompt();
	}

}
