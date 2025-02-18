package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties property;
	String path = "config.properties";

	public ReadConfig() {
		property = new Properties();
		FileInputStream fis;
		try (FileInputStream fis1 = new FileInputStream(path)) {
			property.load(fis1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getBrowser() {
		String value = property.getProperty("browser");
		if (value != null && !value.isEmpty()) {
			return value;
		} else {
			throw new RuntimeException("URl not specified in config file.");
		}

	}
}
