package com.aboruo.disruptor.study.lession01;

import java.math.BigDecimal;

/**
 * 类名称：TrandeEvent
 * 类描述：交易信息model
 * @author aboruo
 * @date 2017年7月6日 上午10:32:16
 */
public class TrandeEvent {
	/** 订单id */
	private String tradeId;
	/** 订单名称 */
	private String trandeName;
	/** 订单金额 */
	private BigDecimal tradeAmount;
	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	/**
	 * @return the trandeName
	 */
	public String getTrandeName() {
		return trandeName;
	}
	/**
	 * @param trandeName the trandeName to set
	 */
	public void setTrandeName(String trandeName) {
		this.trandeName = trandeName;
	}
	/**
	 * @return the tradeAmount
	 */
	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}
	/**
	 * @param tradeAmount the tradeAmount to set
	 */
	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
}
