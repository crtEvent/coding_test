package com.codingtest.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author : crtEvent
 * @date   : 2022. 11. 19.
 */
public class P013_CardGame {
	
	public void runMySolution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("카드의 개수를 입력하세요.");
		int numOfCard = Integer.parseInt(br.readLine());
		
		Queue<Integer> deck = new LinkedList<>();
		
		// deck에 card를 순서대로 넣기
		for(int i = 0; i < numOfCard; i++) {
			deck.add(i+1);
		}
		System.out.printf("덱: %s\n", deck.toString());
		
		// 마지막에 남는 card 구하기
		boolean isContinue = true;
		while(isContinue) {
			// 1. 가장 위에 있는 카드를 버린다
			deck.poll();
			
			// 2. 그다음 가장 위에 있는 카드를 가장 아래로 옮긴다.
			int cardTop = deck.poll();
			deck.add(cardTop);
			
			// 3. deck을 출력
			System.out.printf("덱: %s\n", deck.toString());
			
			if(deck.size() == 1) {
				System.out.printf("마지막에 남은 카드는 %d입니다.", cardTop);
				isContinue = false;
			}
		}
	}
	
	public void runSolution() {
		System.out.println("카드의 개수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = sc.nextInt();
		
		// 카드를 큐에 저장하기
		for(int i = 1; i <= N; i++) {
			myQueue.add(i);
		}
		
		while(myQueue.size() > 1) { // 카드가 1장 남을 때까지
			myQueue.poll(); // 맨 위의 카드를 버림
			myQueue.add(myQueue.poll()); // 맨 위의 카드를 가장 아래로 이동
		}
		
		System.out.printf("마지막에 남은 카드는 %d입니다.", myQueue.poll());
		sc.close();
	}

	public static void main(String[] args) throws IOException {
		P013_CardGame p = new P013_CardGame();
		p.runMySolution();
	}

}
