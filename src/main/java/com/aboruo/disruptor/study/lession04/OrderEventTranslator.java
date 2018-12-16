package com.aboruo.disruptor.study.lession04;

import java.util.UUID;
import com.aboruo.disruptor.study.lession02.OrderEvent;
import com.lmax.disruptor.EventTranslator;

/**
 * 类名称：OrderEventTranslator
 * 类描述：生产完数据publish时，会进行回调，对orderEvent进行处理
 * @author aboruo
 * @date 2017年7月6日 下午6:30:41
 */
public class OrderEventTranslator implements EventTranslator<OrderEvent>{
	
	public void generateOrderId(OrderEvent event){
		event.setOrderId(UUID.randomUUID().toString());
	}
	@Override
	public void translateTo(OrderEvent event, long sequence) {
		this.generateOrderId(event);
	}
}
