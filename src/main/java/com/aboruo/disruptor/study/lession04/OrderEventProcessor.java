package com.aboruo.disruptor.study.lession04;

import com.aboruo.disruptor.study.lession02.OrderEvent;
import com.aboruo.disruptor.study.lession02.OrderEventMain1;
import com.lmax.disruptor.EventHandler;

/**
 * 类名称：OrderEventProcessor
 * 类描述：orderEvent消息处理者
 * @author aboruo
 * @date 2017年7月6日 下午6:41:23
 */
public class OrderEventProcessor implements EventHandler<OrderEvent> {
	private String processorName;
	public OrderEventProcessor(String processorName) {
		this.processorName = processorName;
	}
	/**
	 * @return the processorName
	 */
	public String getProcessorName() {
		return processorName;
	}
	/**
	 * @param processorName the processorName to set
	 */
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	/**
	 * @Title: onEvent
	 * @Description: 处理者处理订单，负责设置订单日期
	 * @author: aboruo
	 * @param event
	 * @param sequence
	 * @param endOfBatch
	 * @throws Exception  
	 * @date 2017年7月6日 下午6:48:47
	 */
	@Override
	public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
		String orderDate = OrderEventMain1.getCurrentStringDateHHMMSS();
		System.out.println(this.processorName + "设定了订单日期为：" + orderDate);
		event.setOrderDate(orderDate);
	}
}
