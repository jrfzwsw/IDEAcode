package com.jd.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore1 {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(3);{

			for (int i = 0; i < 54; i++) {
				new Thread(()->{
					try {
						s.acquire();
						System.out.println(Thread.currentThread().getName() + "in");
						TimeUnit.SECONDS.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						s.release();
					}
					System.out.println(Thread.currentThread().getName()+ "out");
				}).start();
			}
		}
	}
}
