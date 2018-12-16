package com.aboruo.disruptor.study.lession01;

import com.lmax.disruptor.EventFactory;

/**
 * 类名称：TradeEventFactory
 * 类描述：TradeEvent生产工厂
 * @author aboruo
 * @date 2017年7月6日 上午10:43:34
 */
public class TradeEventFactory implements EventFactory<TradeEvent> {

	@Override
	public TradeEvent newInstance() {
		return new TradeEvent();
	}

}
