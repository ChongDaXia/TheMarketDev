package com.zhbit.market;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;

public class BeetlSqlTest {
	public static void main(String[] args) {
//		ConnectionSource source=ConnectionSourceHelper.getSingle((DataSource) ds);
		//数据库连接
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/market?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
		String userName="root";
		String password="xu952822365";
		ConnectionSource source=ConnectionSourceHelper.getSimple(driver, url, userName, password);
		//数据库风格
		DBStyle mysql=new MySqlStyle(); 
		//sql语句存放位置
		SQLLoader loader=new ClasspathLoader("/sql");
		//数据库命名和java命名
		UnderlinedNameConversion nc=new UnderlinedNameConversion();
		//创建SQLManager
		SQLManager sqlManager=new SQLManager(mysql,loader,source,nc,new Interceptor[] {new DebugInterceptor()});
		//UserDaoImpl userDaoImpl=new UserDaoImpl();
		try {
			//List<BUser> users=userDaoImpl.getUserByUNamePwd("admin","123");
//			Integer pk=1;
//			BUser user=sqlManager.single(BUser.class, pk);
//			System.out.println(user.getName());
//			sqlManager.genPojoCode("b_rent", "com.zhbit.market.entity");
//			sqlManager.genPojoCode("b_take_office", "com.zhbit.market.entity");
//			sqlManager.genPojoCode("b_member", "com.zhbit.market.entity");
//			System.out.println("创建成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
