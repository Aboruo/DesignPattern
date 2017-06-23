package com.aboruo.constructor.queuelearn;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class NetPlayer implements Delayed {
	/** 身份证 */
	private String id;
	/** 姓名 */
	private String name;
	/** 上机结束时间 */
	private long endTime;
	/** 上机时间单位 */
	private TimeUnit timeUnit = TimeUnit.SECONDS;
	public NetPlayer() {
	}
	public NetPlayer(String id,String name,long endTime){
		this.id = id;
		this.name = name;
		this.endTime = endTime;
	}
	@Override
	public int compareTo(Delayed o) {
		return this.getDelay(timeUnit) - o.getDelay(this.timeUnit) > 0 ? 1: 0;
	}
	@Override
	public long getDelay(TimeUnit unit) {
		return endTime - System.currentTimeMillis();
	}
	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
