package com.jd.waitandnotify;

public class SynchronizedBlock {
	public static void main(String[] args) {
		Bread bread = new Bread();
		new Thread(()->{
			while(true){
				bread.producto();
			}
		}).start();
		new Thread(()-> {
			while (true){
				bread.consumer();
			}
		}).start();
	}
}
