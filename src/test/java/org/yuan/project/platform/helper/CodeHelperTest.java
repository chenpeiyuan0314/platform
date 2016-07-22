package org.yuan.project.platform.helper;

import org.junit.Assert;
import org.junit.Test;

public class CodeHelperTest {

	@Test
	public void testToken() {
		System.out.println(CodeHelper.token());
	}
	
	@Test
	public void testSha() {
		String encode = CodeHelper.sha("123456");
		Assert.assertEquals("7C4A8D09CA3762AF61E59520943DC26494F8941B", encode);
	}
	
	@Test
	public void testMd5() {
		String encode = CodeHelper.md5("123456");
		Assert.assertEquals("E10ADC3949BA59ABBE56E057F20F883E", encode);
	}
}
