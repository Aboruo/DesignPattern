package com.aboruo.DesignPattern.TemplateMethod.abstracts;

import java.util.Map;

import com.aboruo.DesignPattern.TemplateMethod.dao.PeopleGetRewardsServiceDao;
import com.alibaba.fastjson.JSONObject;

public abstract class PeopleGetRewardsServiceAbs implements PeopleGetRewardsServiceDao {

	/**
	 * @Title:analysisParam
	 * @Description:基本方法，解析从上层传递过来的参数,在具体实现类中写业务实现
	 * @author:aboruo
	 * @param map
	 * @return Map<String,Object>
	 * @date 2016年9月18日 上午1:00:00
	 */
	public abstract Map<String, Object> analysisParam(Map<String,Object> map);
	/**
	 * @Title:checkEnoughRewardsToDistribute
	 * @Description:基本方法，校验奖品是否足够分发,在具体实现类中写业务实现
	 * @author:aboruo
	 * @param map
	 * @return JSONObject
	 * @date 2016年9月18日 上午1:03:59
	 */
	public abstract JSONObject checkEnoughRewardsToDistribute(Map<String,Object> map);
	/**
	 * @Title:distributeRewardsForUsers
	 * @Description:基本方法 公用代码段，给用户分发奖品并核减库存
	 * @author:aboruo
	 * @param map
	 * @return JSONObject
	 * @date 2016年9月18日 上午1:09:50
	 */
	public JSONObject distributeRewardsForUsers(Map<String,Object> map){
		JSONObject resultJSON = new JSONObject();
		System.out.println("分发奖品给用户...并减少了相应的库存");
		resultJSON.put("status", 1);
		resultJSON.put("message", "奖品分发完成，并完成库存核减。");
		return resultJSON;
	}
	/**
	 * @Title:distributRewardsToUsers
	 * @Description:模板方法，给用户分发奖品业务步骤方法
	 * @author:aboruo
	 * @param map
	 * @return Map<String,Object>
	 * @date 2016年9月18日 上午1:00:00
	 */
	@Override
	public JSONObject distributRewardsToUsers(Map<String, Object> map) throws Exception {
		/** 1 解析参数中用户发券参数 */
		Map<String,Object> resultsParam = analysisParam(map);
		
		/** 2 检查该平台奖品类剩余的奖品是否足够发放,足够继续 */
		JSONObject retValut = checkEnoughRewardsToDistribute(resultsParam);
		
		/** 3 分发奖品给用户并减少相应库存 */
		retValut = distributeRewardsForUsers(resultsParam);
		
		/** 4 相应平台对应分发奖品剩余数量减少，依据具体业务查看是否需要做该业务操作 */
		if(ifDecreasePlatFormRewardsNums(resultsParam)){
			retValut = this.decreasePlatFormRewardsNums(resultsParam);
		}
		return retValut;
	}
	/**
	 * @Title:ifDecreasePlatFormRewardsNums
	 * @Description:钩子方法，是否需要减少平台奖品剩余数量，根据具体业务实现来重写
	 * 该钩子方法，默认返回false
	 * @author:aboruo
	 * @param map
	 * @return boolean
	 * @date 2016年9月18日 上午1:15:02
	 */
	public  boolean ifDecreasePlatFormRewardsNums(Map<String, Object> map){
		return false;
	}
	/**
	 * @Title:DecreasePlatFormRewardsNums
	 * @Description:减去平台相应奖品分发数量
	 * @author:aboruo
	 * @param map
	 * @return JSONObject
	 * @date 2016年9月18日 上午1:16:42
	 */
	public abstract JSONObject decreasePlatFormRewardsNums(Map<String, Object> map);
}
