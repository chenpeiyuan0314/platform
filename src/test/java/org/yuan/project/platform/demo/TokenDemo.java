package org.yuan.project.platform.demo;

import java.util.UUID;

import org.junit.Test;

public class TokenDemo {
	
	@Test
	public void testUUID() {
		UUID id = UUID.randomUUID();
		
		System.out.println(id.toString().length());
		System.out.println(id.toString());
	}
}
