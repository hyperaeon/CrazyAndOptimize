package com.crazy.chapter6.duplicate;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

	public static void main(String[] args) throws Exception {
		String str = new String("test phantom");
		ReferenceQueue<String> rq = new ReferenceQueue<>();
		PhantomReference<String> pr = new PhantomReference<>(str, rq);
		System.out.println(rq.poll() == pr);
		str = null;
		System.out.println(pr.get());
		System.gc();
		System.runFinalization();
		System.out.println(rq.poll() == pr);
	}
}
