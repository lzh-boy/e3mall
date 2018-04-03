package cn.e3mall.content.jedis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * 使用jedis操作redis，测试
 *
 * @author colg
 */
public class JedisTest {

	/**
	 * redis 单机
	 */
	@Test
	public void testJedic() {
		// 创建一个jedis对象，参数：host，port
		Jedis jedis = new Jedis("192.168.21.103", 6379);
		// 直接使用jedis操作redis，所有jedis的命令都对应一个方法
		jedis.set("test123", "my first jedis test");
		System.out.println(jedis.get("test123"));
		// 关闭连接
		jedis.close();
	}

	/**
	 * redis 连接池
	 */
	@Test
	public void testJedisPool() {
		// 创建一个连接池对象，两个参数host、post，连接池是单例的
		JedisPool jedisPool = new JedisPool("192.168.21.103", 6379);
		// 从连接池获得一个连接，就是jedis对象
		Jedis jedis = jedisPool.getResource();
		// 使用jedis操作redis
		System.out.println(jedis.get("test123"));
		// 关闭连接，每次使用完毕后关闭连接，连接池回收资源
		jedis.close();
		// 关闭连接
		jedisPool.close();
	}

	/**
	 * redis 集群
	 */
	@Test
	public void testJedisCluster() {
		// 创建一个JedisCluster对象，有一个参数nodes是一个set类型，set中包含若干个HostAndPort对象
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.21.103", 7000));
		nodes.add(new HostAndPort("192.168.21.103", 7001));
		nodes.add(new HostAndPort("192.168.21.103", 7002));
		nodes.add(new HostAndPort("192.168.21.103", 7003));
		nodes.add(new HostAndPort("192.168.21.103", 7004));
		nodes.add(new HostAndPort("192.168.21.103", 7005));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		// 直接使用JedisCluster对象操作redis，操作完不用关闭，自带连接池
		jedisCluster.set("test", "123");
		System.out.println(jedisCluster.get("test"));
		// 系统关闭前，关闭JedisCluster对象
		try {
			jedisCluster.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
