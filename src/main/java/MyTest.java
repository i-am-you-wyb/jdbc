import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

public class MyTest {
    public static void main(String[] args) throws IOException {
        // 加载配置文件
        Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
        // 创建构造器对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建工厂
        SqlSessionFactory sqlSessionFactory = builder.build(reader);
        //创建执行对象
        SqlSession session = sqlSessionFactory.openSession();
        // 执行sql语句

        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("E:/mysql.txt")));
        String s="";
        while ((s=br.readLine())!=null) {
           // session.insert("insert",s);
            UserDao a=session.getMapper(UserDao.class);
            a.insert(s);
        }
        // 提交事务
        session.commit();
        session.close();
    }
}
