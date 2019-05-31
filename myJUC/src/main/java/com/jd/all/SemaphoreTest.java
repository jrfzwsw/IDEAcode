package com.jd.all;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(3);
		for (int i = 0; i < 54; i++) {
			new Thread(()->{
				try {
					s.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					System.out.println(Thread.currentThread().getName() + "in");
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName() + "out");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					s.release();
				}
			},String.valueOf(i)).start();
		}
	}
}
