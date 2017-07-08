package com.aboruo.disruptor.study.lession01;

import com.lmax.disruptor.EventHandler;

public class TradeEventConsumer<T> implements EventHandler<TradeEvent> {
	private String tradeConsumerName;
	public TradeEventConsumer(String string) {
		this.tradeConsumerName = string;
	}
	/**
	 * @return the tradeConsumerName
	 */
	public String getTradeConsumerName() {
		return tradeConsumerName;
	}
	/**
	 * @param tradeConsumerName the tradeConsumerName to set
	 */
	public void setTradeConsumerName(String tradeConsumerName) {
		this.tradeConsumerName = tradeConsumerName;
	}
	@Override
	public void onEvent(TradeEvent tradeEvent, long arg1, boolean arg2) throws Exception {
		System.out.println(this.getTradeConsumerName() + "消费了：" + tradeEvent.getTradeId() + "|" + tradeEvent.getTrandeName() + "|" + tradeEvent.getTradeAmount());
	}

}
