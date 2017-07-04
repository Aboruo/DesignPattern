package com.aboruo.constructor.futuremodel;

public class FutureData implements Data {
	private String result;
	private RealData realData;
	private boolean isRrealDataReady = false;
	
	/**
	 * @return the isRrealDataReady
	 */
	public boolean isRrealDataReady() {
		return isRrealDataReady;
	}
	/**
	 * @param isRrealDataReady the isRrealDataReady to set
	 */
	public void setRrealDataReady(boolean isRrealDataReady) {
		this.isRrealDataReady = isRrealDataReady;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the realData
	 */
	public RealData getRealData() {
		return realData;
	}
	/**
	 * @param realData the realData to set
	 */
	public synchronized void setRealData(RealData realData) {
		if(isRrealDataReady){
			return;
		}
		this.realData = realData;
		isRrealDataReady = true;
		//进行通知
		notify();
	}
	public FutureData() {
		this.result = "正在查询请稍后...";
	}
	@Override
	public synchronized String getRequest() {
		if(!isRrealDataReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.realData.getRequest();
	}

}
