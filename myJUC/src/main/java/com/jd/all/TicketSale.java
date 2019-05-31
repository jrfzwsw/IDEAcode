package com.jd.all;

public class TicketSale {
	public static void main(String[] args) {
		Resources r = new Resources();
		new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				r.sale();
			}
		}, "one====>").start();

		new Thread(()->{
			for (int i = 0; i < 30; i++) {
				r.sale();
			}
		},"two====>").start();

		new Thread(()->{
			for (int i = 0; i < 30; i++) {
				r.sale();
			}
		},"three====>").start();



	}
}
