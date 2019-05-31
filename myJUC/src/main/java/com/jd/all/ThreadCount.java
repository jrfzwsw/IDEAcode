package com.jd.all;

import java.util.concurrent.CountDownLatch;

public class ThreadCount {
	public static void main(String[] args) {
		CountDownLatch count = new CountDownLatch(54);
		for (int i = 0; i < 54; i++) {
			new Thread( ()->{
				System.out.println(Thread.currentThread().getName() + "leave");
				count.countDown();
			},String.valueOf(i)).start();

		}
		try {
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("no  one  ");
	}
}
