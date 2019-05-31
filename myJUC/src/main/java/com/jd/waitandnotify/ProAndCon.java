package com.jd.waitandnotify;

public class ProAndCon {

	private Integer breadNum= 0;

	public synchronized void productor( ){
		if(breadNum!=0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		breadNum++;
		System.out.println(Thread.currentThread().getName() + String.valueOf(breadNum));
		notify();
	}
	public  synchronized void consumer(  ){
		if(breadNum==0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		breadNum--;
		System.out.println(Thread.currentThread().getName() + String.valueOf(breadNum));
		notify();
	}

}
