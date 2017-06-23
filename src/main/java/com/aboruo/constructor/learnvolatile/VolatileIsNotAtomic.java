package com.aboruo.constructor.learnvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileIsNotAtomic extends Thread {
//	private static volatile int count;
	private static AtomicInteger count = new AtomicInteger(0);
	private static void addCount(){
		for(int i = 0 ; i < 1000;i++)
			count.incrementAndGet();
		System.out.println("count的值：" + count);
	}
	public void run(){
		addCount();
	}
	public static void main(String[] args) {
		VolatileIsNotAtomic[] volatileIsNotAtomics = new VolatileIsNotAtomic[10];
		for(int i = 0; i < volatileIsNotAtomics.length; i++){
			volatileIsNotAtomics[i] = new VolatileIsNotAtomic();
		}
		for(int j = 0 ; j < volatileIsNotAtomics.length; j++){
			volatileIsNotAtomics[j].start();
		}
	}

}
