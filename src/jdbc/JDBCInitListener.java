package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class JDBCInitListener
 *
 */
@WebListener
public class JDBCInitListener implements ServletContextListener {

	/**
	 * Default constructor. 
	 */
	public JDBCInitListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce)  { 

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce)  { 

		ServletContext application = sce.getServletContext();
//		application.setInitParameter("jdbcUrl", "jdbc:oracle:thin:@localhost:1521:orcl");
//		application.setInitParameter("jdbcUser", "c##mydbms");
//		application.setInitParameter("jdbcPassword", "admin");

		String url = application.getInitParameter("jdbcUrl");
		String user = application.getInitParameter("jdbcUser");
		String password = application.getInitParameter("jdbcPassword");

		//잘 적용 됬는지 체크 !!
//		System.out.println(url);
//		System.out.println(user);
//		System.out.println(password);

		//클래스 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		try(
				//driverManager에서 connection 얻기
				Connection con = DriverManager.getConnection(url, user, password);
				){
			System.out.println("성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionProvider.setUrl(url);
		ConnectionProvider.setUser(user);
		ConnectionProvider.setPassword(password);

		//context root 경로
		String contextPath = application.getContextPath();
		application.setAttribute("root", contextPath);
	}

}


