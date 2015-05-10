package com.crazy.chapter16;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

class PrintTask extends RecursiveAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int THRESHHOLD = 50;
	
	private int start;
	
	private int end;
	
	public PrintTask(int start,int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected void compute() {
		if(end - start < THRESHHOLD){
			for(int i = start; i < end; i ++){
				System.out.println(Thread.currentThread().getName() + "µÄiÖµ " + i);
			}
		}else{
			int middle = (end + start) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			left.fork();
			right.fork();
		}
	}
	
}
public class ForkJoinPoolTest {

	public static void main(String[] args)throws Exception{
		ForkJoinPool pool = new ForkJoinPool();
		pool.submit(new PrintTask(0,300));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		pool.shutdown();
		System.out.println(ComplexEnum.Alpha);
	}
}
