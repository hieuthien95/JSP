package connect;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

public class Main {
	public static void main(String[] args) throws IOException {

		// write property file
		Properties properties = new Properties();
		properties.setProperty("user", "Thien Su");
		FileWriter writer = new FileWriter("config.properties");
		properties.store(writer, "Author: Thien Su");
		writer.close();

		// read property file
		try {
			FileInputStream fis = new FileInputStream("config.properties");
			Properties p = new Properties();
			p.load(fis);
			String LogFileName = p.getProperty("user");
			System.out.println(LogFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
