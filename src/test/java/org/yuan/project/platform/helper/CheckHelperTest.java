package org.yuan.project.platform.helper;

import org.junit.Test;

public class CheckHelperTest {

	@Test
	public void testCheckPassword() {
		String pwd = "chen1987";
		CheckHelper.checkPassword(pwd);
	}
}
