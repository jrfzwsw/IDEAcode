package com.jd.waitandnotify;

public class Bread {
	private  Object obj = new Object();
	private  Integer num = 0;
	public void producto(){
		synchronized (obj){
			if(num ==0){
				num++;
				obj.notify();

				System.out.println(Thread.currentThread().getName()+ num);
			}else {
				try {
					obj.wait();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void consumer(){
		synchronized (obj){
			if(num !=0){
				num--;
				obj.notify();
				System.out.println(Thread.currentThread().getName()+ num);
			}else {
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
