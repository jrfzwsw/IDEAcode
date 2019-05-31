package com.jd.one;

public class Ticket {

	private Integer ticket=30;

	public  synchronized   void  sale(  ){

		if(ticket!=0){
			ticket--;
			System.out.println(Thread.currentThread().getName()+ "remainder ticket " + ticket);

		}
	}
}
