package com.jd.all;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadCyclicTest {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(54,()->{
			System.out.println("bye");});

		for (int i = 0; i < 54; i++) {
			new Thread(()->{

				System.out.println(Thread.currentThread().getName() + "  arrived");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}

	}

}
