package com.jd.countTTT;

import java.util.concurrent.CountDownLatch;

public class Count1 {
	public static void main(String[] args) {
		CountDownLatch count = new CountDownLatch(54);
		for (int i = 54; i >= 0; i--) {
			new Thread(()-> {
				System.out.println(Thread.currentThread().getName() + "leave");
			},String.valueOf(i)).start();

		}
		try {
			count.await();
			System.out.println(" no one");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
