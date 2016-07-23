package org.yuan.project.platform.model;

import org.yuan.project.platform.entity.Client;

public class ClientJson {
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public void setUsername(Client client) {
		if(client.getUsername() != null) {
			setUsername(client.getUsername());
			return;
		}
		
		String phone = client.getPhone();
		phone = phone.substring(0,3) + "****" + phone.substring(7, 11);
		setUsername(phone);
	}
	
	private String username;
	private String token;
}
