package com.jd.lock;

public class lock1 {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();

		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.sale();
			}
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.sale();
			}
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				ticket.sale();
			}
		}).start();
	}
}
