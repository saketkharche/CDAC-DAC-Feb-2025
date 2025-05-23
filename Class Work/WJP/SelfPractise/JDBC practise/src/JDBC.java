import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	private static final String DBURL="http://localhost/3306/adv_java";
		private static final String USER="root";
		private static final String PASS="cdac";
	Connection con=DriverManager.getConnection(DBURL,USER,PASS);
}
