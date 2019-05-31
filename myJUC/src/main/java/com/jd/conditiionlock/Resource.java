package com.jd.conditiionlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
	Lock lock =new ReentrantLock();

	final Condition add =lock.newCondition();
	final Condition sub =lock.newCondition();

	private  Integer num = 1;
	public void add(){
		lock.lock();
		if(num ==0){
			num++;
			System.out.println(Thread.currentThread().getName()+ num);
			sub.signalAll();
		}
		try {
			add.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}

	public void sub(){
		lock.lock();
		if(num ==1){
			num--;
			System.out.println(Thread.currentThread().getName()+ num);
			add.signalAll();
		}
		try {
			sub.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}
}
