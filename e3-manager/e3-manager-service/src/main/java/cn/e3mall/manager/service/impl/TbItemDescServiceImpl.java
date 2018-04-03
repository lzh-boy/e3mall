package cn.e3mall.manager.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.e3mall.manager.core.BaseServiceImpl;
import cn.e3mall.manager.pojo.TbItemDesc;
import cn.e3mall.manager.service.TbItemDescService;

/**
 * 
 *
 * @author colg
 */
@Service
public class TbItemDescServiceImpl extends BaseServiceImpl implements TbItemDescService {

	@Value("${ITEM_INFO_PRE}")
	private String ITEM_INFO_PRE;
	@Value("${ITEM_INFO_EXPIRE}")
	private Integer ITEM_INFO_EXPIRE;

	@Override
	public TbItemDesc findById(Long itemId) {
		// 查询缓存
		String key = ITEM_INFO_PRE + ":" + itemId + ":DESC";
		try {
			String jsonString = jedisClient.get(key);
			if (StringUtils.isNotBlank(jsonString)) {
				return JSON.parseObject(jsonString, TbItemDesc.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 查询数据库
		TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(itemId);

		if (tbItemDesc != null) {
			try {
				// 添加缓存
				jedisClient.set(key, JSON.toJSONString(tbItemDesc));
				// 设置缓存过期时间
				jedisClient.expire(key, ITEM_INFO_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tbItemDesc;
	}

}
