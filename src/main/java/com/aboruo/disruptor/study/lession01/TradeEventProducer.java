package com.aboruo.disruptor.study.lession01;

import java.math.BigDecimal;
import java.util.Map;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

/**
 * 类名称：TradeEventProducer
 * 类描述：订单信息生产者
 * @author aboruo
 * @date 2017年7月6日 上午10:54:23
 */
public class TradeEventProducer {
	private EventTranslatorOneArg<TradeEvent,Map<String,String>> TRANSLATOR = new EventTranslatorOneArg<TradeEvent, Map<String,String>>(){
		@Override
		public void translateTo(TradeEvent tradeEvent, long sequence, Map<String,String> map) {
			tradeEvent.setTradeId(map.get("tradeId"));
			tradeEvent.setTrandeName(map.get("trandeName"));
			tradeEvent.setTradeAmount(BigDecimal.valueOf(Double.parseDouble(map.get("tradeAmount"))));
		}
	};
	private final RingBuffer<TradeEvent> ringBuffer;
	public TradeEventProducer(RingBuffer<TradeEvent> ringBuffer) {
		super();
		this.ringBuffer = ringBuffer;
	}
	/**
	 * @Title:onData
	 * @Description: 生产TradeEvent并发布给消费者
	 * @author:aboruo
	 * @param tradeEvent void
	 * @date 2017年7月6日 上午10:53:37
	 */
	public void onData(Map<String,String> map){
		System.out.println("生产并发布订单：" + map.get("trandeName"));
		ringBuffer.publishEvent(TRANSLATOR, map);
	}
}
