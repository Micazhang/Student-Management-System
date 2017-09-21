/*数据库连接类*/
//导入sql数据库包
import java.sql.*;
//创建数据库连接类
public class DBConnect{
	//静态方法提高数据库的连接效率
	public static Connection getConn() throws Exception{
		//驱动程序名
		String driver="com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名:managestudents
		String url="jdbc:mysql://localhost:3306/stephanos?useSSL=false";
		//连接数据库的用户名
		String user="root";
		//Java连接MySQL数据库用户的密码
		String passwd="mica123";
		//加载JDBC驱动---返回与带有给定字符串名的类或接口相关联的 Class 对象。
		//第11行和下面这行不写也没关系，可能与工程中添加的mysql-connector-java-5.1.39-bin.jar有关吧
		Class.forName(driver);
		//创建连接数据库的对象conn
		Connection conn=DriverManager.getConnection(url,user,passwd);
		return conn;
		/**
		 * 以上7行程序可以简写如下1行：
		 * return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentsmanager?useSSL=false","root","lindejun");
		 * 这样写法紧凑，但是可读性比较差。
		 * */
	}
}
