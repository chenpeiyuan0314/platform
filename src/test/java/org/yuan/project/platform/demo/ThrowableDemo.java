package org.yuan.project.platform.demo;

import org.junit.Test;

public class ThrowableDemo {

	@Test
	public void demo() {
		Throwable t = new Throwable();
		StackTraceElement[] elements = t.getStackTrace();
		for(StackTraceElement element : elements) {
			System.out.println(element);
			System.out.println(element.getLineNumber() + " - " + element.getFileName());
		}
	}
}
