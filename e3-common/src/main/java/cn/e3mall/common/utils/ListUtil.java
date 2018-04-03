package cn.e3mall.common.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单列集合工具类
 *
 * @author colg
 */
public class ListUtil {

	/**
	 * 检查集合是否为null或空(Size = 0)
	 *
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * 检查集合是否不为null，也不为空(Size = 0)
	 *
	 * @param list
	 * @return
	 */
	public static <T> boolean isNotEmpty(List<T> list) {
		return !isEmpty(list);
	}

	/**
	 * 获取集合中的第一个对象，集合为空或null，则返回null
	 * 
	 * @param <T>
	 *
	 * @param list
	 * @return
	 */
	public static <T> T getFirstElement(List<T> list) {
		return isEmpty(list) ? null : list.get(0);
	}

	/**
	 * 去掉集合中重复的值
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<T> distinct(List<T> list) {
		Set<T> set = new HashSet<>(list);
		list.clear();
		list.addAll(set);
		return list;
	}
}
