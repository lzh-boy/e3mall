package cn.e3mall.common.jedis;

import java.util.List;

/**
 * resid 客户端
 *
 * @author colg
 */
public interface JedisClient {

	/**
	 * 将字符串值设置为键的值。 字符串不能超过1073741824字节（1 GB）。
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key, String value);

	/**
	 * 获取指定键的值。 如果该键不存在，则返回null。 如果存储在键上的值不是字符串，则返回错误，因为GET只能处理字符串值。
	 * 
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 * 删除指定的键。 如果给定的键不存在，则不对该键执行操作。 该命令返回删除的键数。 时间复杂度：O（1）
	 * 
	 * @param key
	 * @return 整数回复，具体为：如果删除一个或多个键，则为大于0的整数如果指定的键均不存在，则返回0
	 */
	Long del(String... key);

	/**
	 * 
	 * 测试指定的密钥是否存在。 如果密钥存在，则该命令返回“1”，否则返回“0”。 请注意，即使键值设置为空字符串，也会返回“1”。 时间复杂度：O（1）
	 * 
	 * @param key
	 * @return 如果密钥存在，则返回true，否则返回false
	 */
	Boolean exists(String key);

	/**
	 * 
	 * 在指定的键上设置超时。超时后，服务器将自动删除密钥。据说Redis术语中有一个关联超时的关键字是不稳定的。
	 * 
	 * 灵活键与其他键一样存储在磁盘上，超时也像数据集的所有其他方面一样持久。保存包含expires和停止服务器的数据集不会阻止时间流，因为Redis在磁盘上存储的密钥将不再以Unix时间可用，而不是剩余的秒数。
	 * 
	 * 从Redis 2.1.3开始，您可以更新已经过期的密钥的超时值。使用PERSIST命令将密钥转换为普通密钥也是可能的。
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	Long expire(String key, int seconds);

	/**
	 * TTL命令返回剩余时间，以秒为单位设置EXPIRE。 这种内省功能允许Redis客户端检查给定密钥将继续成为数据集的一部分的秒数。
	 * 
	 * @param key
	 * @return
	 */
	Long ttl(String key);

	/**
	 * 将存储在密钥中的数字加1。 如果键不存在或包含错误类型的值，则在执行递增操作之前将键设置为值“0”。
	 * 
	 * INCR命令限于64位有符号整数。
	 * 
	 * 注意：这实际上是一个字符串操作，也就是说，在Redis中不存在“整数”类型。 只需将存储在密钥中的字符串解析为基本10位64位有符号整数，然后将其作为字符串转换回来。
	 * 
	 * @param key
	 * @return
	 */
	Long incr(String key);

	/**
	 * 将指定的散列字段设置为指定的值。
	 * 
	 * 如果密钥不存在，则会创建一个保存散列的新密钥。
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	Long hset(String key, String field, String value);

	/**
	 * 如果密钥包含散列，则检索与指定字段关联的值。
	 * 
	 * 如果未找到该字段或者该键不存在，则返回一个特殊的'nil'值。
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	String hget(String key, String field);

	/**
	 * 从密钥中存储的散列中删除指定的字段。
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	Long hdel(String key, String... field);

	/**
	 * 测试散列中是否存在指定的字段。 时间复杂度：O（1） 如果存储在密钥中的散列包含指定的字段，则返回1。 如果没有找到该键或该字段不存在，则返回0。
	 * 
	 * @param key
	 * @param field
	 * @return 如果改键与字段同时存在，则返回true，否则返回false
	 */
	Boolean hexists(String key, String field);

	/**
	 * 返回散列中的所有值。 时间复杂度：O（N），其中N是条目的总数
	 * 
	 * @param key
	 * @return 所有字段值都包含在一个散列中。
	 */
	List<String> hvals(String key);
}
