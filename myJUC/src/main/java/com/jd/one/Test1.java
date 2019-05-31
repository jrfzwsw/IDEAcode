package com.jd.one;

public class Test1 {

	public static void main(String[] args) {
		Ticket t = new Ticket();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 30; i++) {
					t.sale();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 30; i++) {
					t.sale();
				}
			}
		}).start();

	}
}
