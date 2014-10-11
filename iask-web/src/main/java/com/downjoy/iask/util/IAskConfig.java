package com.downjoy.iask.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author lxw
 * 解析iask.properties
 */
public class IAskConfig {
	private static IAskConfig instance;
	private ResourceBundle resourceBundle = ResourceBundle.getBundle("iask");

	private IAskConfig() {

	}

	public static IAskConfig getInstance() {
		if (instance == null) {
			synchronized (IAskConfig.class) {
				if (instance == null) {
					instance = new IAskConfig();
				}
			}
		}
		return instance;
	}

	public String getString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public String getIaskSolrUrl(){
		return getString("iask.solr.url");
	}

	public static void main(String[] args) {
		System.out.println(IAskConfig.getInstance().getString("iask.solr.url"));
		System.out.println(IAskConfig.getInstance().getIaskSolrUrl());
	}
}
