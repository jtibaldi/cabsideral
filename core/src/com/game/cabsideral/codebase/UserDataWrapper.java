package com.game.cabsideral.codebase;

public class UserDataWrapper {
	public final String id;
	public final String castInfo;
	public final Object instance;
	
	public UserDataWrapper(String _id, String _castInfo, Object _instance) 
	{
		this.id = _id;
		this.instance = _instance;
		this.castInfo = _castInfo;
	}
}
