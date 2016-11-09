package db;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerContext implements ServletContextListener {

	public static String contextPath;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		contextPath = servletContextEvent.getServletContext().getContextPath();

		Properties boneCPConfigProperties = new Properties();

		try {
			boneCPConfigProperties.load(ServerContext.class.getResourceAsStream("/bonecp.properties"));
		} catch (IOException ex) {
		}
		MySQLConnectionFactory.init(boneCPConfigProperties);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.gc();
		java.beans.Introspector.flushCaches();
	}

}