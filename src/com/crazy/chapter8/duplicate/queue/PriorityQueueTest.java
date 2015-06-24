package com.crazy.chapter8.duplicate.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(9);
		pq.offer(0);
		System.out.println(pq);
		System.out.println(pq.poll());
	}
}
