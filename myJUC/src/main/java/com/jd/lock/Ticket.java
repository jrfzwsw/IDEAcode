package com.jd.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {

	private Integer ticket=30;

	private Lock lock = new ReentrantLock();
	public   void  sale(  ){

		lock.lock();
		if(ticket!=0){
			ticket--;
			System.out.println(Thread.currentThread().getName()+ "remainder ticket " + ticket);

		}
		lock.unlock();
	}
}
