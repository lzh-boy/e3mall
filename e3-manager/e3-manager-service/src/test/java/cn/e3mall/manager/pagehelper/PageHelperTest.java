package cn.e3mall.manager.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.manager.dao.TbItemMapper;
import cn.e3mall.manager.pojo.TbItem;

/**
 * PageHelper 测试分页
 *
 * @author colg
 */
public class PageHelperTest {

	private ApplicationContext applicationContext;

	@Test
	public void testPageHelper() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-dao.xml");
		
		// 从容器中获得Mapper代理对象
		TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
		// 执行sql语句之前设置分页信息，使用PageHelper的startPatge方法
		PageHelper.startPage(1, 10);
		// 执行查询
		List<TbItem> list = tbItemMapper.selectAll();
		// 取分页信息，PageInfo,1：总记录数，2：总页数，当前页码
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(list.size());
	}
	
}
