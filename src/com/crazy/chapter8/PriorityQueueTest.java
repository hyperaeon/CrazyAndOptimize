package com.crazy.chapter8;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args){
		PriorityQueue pq = new PriorityQueue<>();
		pq.offer(6);
		pq.offer(3);
		pq.offer(-1);
		pq.offer(90);
		System.out.println(pq);
		System.out.println(pq.poll());
		
	}
}
