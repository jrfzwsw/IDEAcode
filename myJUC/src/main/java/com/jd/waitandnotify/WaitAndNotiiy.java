package com.jd.waitandnotify;

public class WaitAndNotiiy {


	public static void main(String[] args) {

		ProAndCon pc = new ProAndCon();

		new Thread(() -> {
			while (true) {
				pc.productor();
			}
		}, "productor").start();

		new Thread(() -> {
			while (true) {
				pc.consumer();
			}
		}, "consumer").start();


	}

}
