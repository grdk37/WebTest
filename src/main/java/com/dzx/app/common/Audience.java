package com.dzx.app.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	public void takeSeats() {
		System.out.println("The audience is taking their seats.");
	}

	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}

	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	public void demandRefund() {
		System.out.println("Boo! We want our money back!");
	}

	// 环绕通知
	public void watchPerformance(ProceedingJoinPoint pjp) {
		try {
			System.out.println("around notice before");
			long start = System.currentTimeMillis();
			pjp.proceed();
			long end = System.currentTimeMillis();
			System.out.println("around notice after");
			System.out.println("The performance took " + (end - start) + " milliseconds.");
		} catch (Throwable t) {
			System.out.println("around notice exception");
		}

	}
}