package com.aboruo.constructor.futuremodel;

public class RealData implements Data {
	private String result;
	
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
	public static RealData getRealData(String queryStr){
		System.out.println("RealData 开始查询真实数据======>");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RealData realData = new RealData();
		realData.setResult("得到查询结果aaaaaa");
		System.out.println("查询真实数据完成");
		return realData;
	}
	@Override
	public String getRequest() {
		return result;
	}
}
