package com.jd.diaodu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiaoDu2 {
	private Lock lock = new ReentrantLock();
	private Condition AA = lock.newCondition();
	private Condition BB = lock.newCondition();
	private Condition CC = lock.newCondition();
	private  Integer  num = 0;

	public  void AA ( ){
		lock.lock();
		if(num!=0){
			try {
				AA.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 1; i++) {
			System.out.println("AA  1");
		}
		num=1;
		BB.signal();
	}

	public  void BB ( ){
		lock.lock();
		if(num!=1){
			try {
				BB.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i <2; i++) {
			System.out.println("BB    2");
		}
		num=2;
		CC.signal();
	}
	public  void CC ( ){
		lock.lock();
		if(num!=2){
			try {
				CC.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.println("CC      3");
		}
		num=0;
		AA.signal();
	}


}
