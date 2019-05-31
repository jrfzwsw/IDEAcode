package com.jd.cyclicTTTTTTTTTTT;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test1 {

	public static void main(String[] args) {
		CyclicBarrier c = new CyclicBarrier( 54,()->{
			System.out.println("gogo");
		});

		for (int i = 0; i < 54; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName() + "arrived");
				try {
					c.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();

		}
	}
}
