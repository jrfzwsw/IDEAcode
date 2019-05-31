package com.jd.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
	ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
	private Integer num = 10;

	public void read() {
		readLock.lock();
		if(num !=0){
			System.out.println(Thread.currentThread().getName() + "   "   +num );
		}
		readLock.unlock();
	}
	public  void write(){
		writeLock.lock();
		if(num !=0){
			System.out.println(Thread.currentThread().getName() + "   " + ++num);
		}

		writeLock.unlock();
	}



}
