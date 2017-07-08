package com.aboruo.constructor.disruptor.learn01;

/**
 * 类描述: 请求事件
 * 类名称: RequestEvent
 * @author aboruo
 * @date 2017年7月2日 下午3:53:49
 * @since 1.0.0
 */
public class RequestEvent {
	private String requestId;
	private String requestInfo;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}
}
