package com.jd.all;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Resources {

	private Integer ticket = 30;
	private Lock lock = new ReentrantLock();
	private Condition prol = lock.newCondition();
	private Condition conl = lock.newCondition();
	private Integer num = 0;

	private Condition AA = lock.newCondition();
	private Condition BB = lock.newCondition();
	private Condition CC = lock.newCondition();
	private ReentrantReadWriteLock lrw = new ReentrantReadWriteLock();

	public  void read(){
		lrw.readLock().lock();
		System.out.println(Thread.currentThread().getName() + num);
		lrw.readLock().unlock();
	}
	public void write(){
		lrw.writeLock().lock();
		System.out.println(Thread.currentThread().getName()+ num++);
		lrw.writeLock().unlock();
	}





	public  void CC(){
		lock.lock();
		if(num ==2){
			for (int i = 0; i < 3; i++) {
				System.out.println("CC");
			}
			num=0;
			AA.signal();
		}
		try {
			CC.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}}
	public  void BB(){
		lock.lock();
		if(num ==1){
			for (int i = 0; i < 2; i++) {
				System.out.println("BB");
			}

			num =2;
			CC.signal();
		}
		try {
			BB.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}}
	public  void AA(){
		lock.lock();
		if(num ==0){
			for (int i = 0; i < 1; i++) {
				System.out.println("AA");
			}
			num=1;
			BB.signal();
		}
		try {
			AA.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void prol() {
		lock.lock();
		if (num == 0) {
			num++;
			System.out.println(Thread.currentThread().getName() + num);
			conl.signalAll();
		}
		try {
			prol.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			lock.unlock();
		}
	}

	public void conl() {
		lock.lock();
		if (num == 1) {
			num--;
			System.out.println(Thread.currentThread().getName() + num);
			prol.signalAll();
		}
		try {
			conl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}


	}


	public void sale() {
		lock.lock();
		try {
			if (ticket != 0) {
				System.out.println(Thread.currentThread().getName() + ticket--);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public synchronized void pors() {
		if (num == 0) {
			num++;
			notify();
			System.out.println(Thread.currentThread().getName() + num);
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void cons() {
		if (num == 1) {
			num--;
			System.out.println(Thread.currentThread().getName() + num);
			notify();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
