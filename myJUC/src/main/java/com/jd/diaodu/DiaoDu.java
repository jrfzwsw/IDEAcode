package com.jd.diaodu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiaoDu {
	private Integer num = 0;

	private Lock lock = new ReentrantLock();

	public void AA() {
		lock.lock();
		if (num == 0) {
			for (int i = 0; i < 1; i++) {
				System.out.println("5   AA");
			}
			num = 1;
		}
		lock.unlock();
	}

	public void BB() {
		lock.lock();
		if (num == 1) {
			for (int i = 0; i < 2; i++) {
				System.out.println("10  BB");
			}
			num = 2;
		}
		lock.unlock();
	}
	public void CC() {
		lock.lock();
		if (num == 2) {
			for (int i = 0; i < 3; i++) {
				System.out.println("15   CC");
			}
			num = 0;
		}
		lock.unlock();
	}

}
