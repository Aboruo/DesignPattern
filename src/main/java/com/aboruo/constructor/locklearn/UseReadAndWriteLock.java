package com.aboruo.constructor.locklearn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类名称：UseReadAndWriteLock 类描述：读写锁测试
 * 
 * @author aboruo
 * @date 2017年6月30日 上午9:42:46
 */
public class UseReadAndWriteLock {
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();

	public void m1() {
		try {
			readLock.lock();
			System.out.println("线程：" + Thread.currentThread().getName() + "开始进入m1方法......");
			Thread.sleep(1000);
			System.out.println("线程：" + Thread.currentThread().getName() + "开始执行m1方法......");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}

	public void m2() {
		try {
			writeLock.lock();
			System.out.println("线程：" + Thread.currentThread().getName() + "开始进入m2方法......");
			Thread.sleep(2000);
			System.out.println("线程：" + Thread.currentThread().getName() + "开始执行m2方法......");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {
		final UseReadAndWriteLock useReadAndWriteLock = new UseReadAndWriteLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				useReadAndWriteLock.m1();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				useReadAndWriteLock.m1();
			}
		}, "t2");
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				useReadAndWriteLock.m2();
			}
		}, "t3");
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				useReadAndWriteLock.m2();
			}
		}, "t4");
		System.out.println(t2.getName());
		System.out.println(t4.getName());
		t1.start();
		t3.start();
		t4.start();
	}

}
