package com.jd.all;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutreTasekTest {
	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Thread.sleep(100);
				TimeUnit.SECONDS.sleep(10);
				return 0;
			}
		};

		FutureTask<Integer> ft = new FutureTask<>(callable);
		new Thread(ft).start();
		try {
			Integer integer = ft.get();
			System.out.println(integer);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("good");

	}
}
