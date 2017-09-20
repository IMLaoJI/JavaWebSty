package com.atguigu.test;

import java.util.UUID;

import org.junit.Test;

public class TestUUID {

	@Test
	public void test() {
		/**
		 * UUID是一个32位的唯一标识符。
		 * UUID是根据机器码以及时间戳计算出来
		 * 所以UUID是一个全世界的一个唯一标识符，永远不会重复
		 * 一般使用UUID来作为一个对象的唯一标识，或者是用来做数据库表中的主键
		 */
		
		String uuid = UUID.randomUUID().toString();
		
		System.out.println(uuid.replace("-", ""));
		
		//时间戳指的就是从1970年1月1日 0时0分0秒 到现在时间的毫秒数
		long cm = System.currentTimeMillis();
		System.out.println(cm);
		
	}

}
