package com.maxc.rest.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName: ConfigUtil
 * 
 * @author ant_shake_tree
 * @version:1.0.0.0
 */
public class ConfigUtil {
	private static final Properties PROPERTIES = new Properties();
	private static String CONFIG = "/config.properties";
	public static void loadConfigFileByPath(String path) {
		InputStream inputStream = ConfigUtil.class.getResourceAsStream(path);
		try {
			PROPERTIES.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getByKey(String key) {
		ConfigUtil.loadConfigFileByPath(CONFIG);
		return PROPERTIES.getProperty(key);
	}
	public static void store(String key,String value) throws IOException{
		PROPERTIES.setProperty(key, value);
		FileOutputStream out =new FileOutputStream(resolveName(CONFIG));
		PROPERTIES.store(out, "");
		
	}
	

	private static String resolveName(String name) {
		if (name == null) {
			return name;
		}
		if (!name.startsWith("/")) {
			Class<?> c = ConfigUtil.class;
			while (c.isArray()) {
				c = c.getComponentType();
			}
			String baseName = c.getName();
			int index = baseName.lastIndexOf('.');
			if (index != -1) {
				name = baseName.substring(0, index).replace('.', '/') + "/"
						+ name;
			}
		} else {
			name = name.substring(1);
		}
		return name;
	}
}
