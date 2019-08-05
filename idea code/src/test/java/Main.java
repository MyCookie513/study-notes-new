import com.jason.Interface.UserMapper;
import com.jason.Mapper.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        //1.读取配置文件  : 1.environment :连接池和事务管理者；2.Mapper：DAO 接口方法的映射文件（内有id方法名和sql语句）：
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.由SqlSessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3.由sqlSessionFactory创建一个会话；session内部通过执行器来操纵数据库，和executor相关联的是MappedStatement：sql语句，输入参数，输出结果类型；
        SqlSession session=factory.openSession();
        //4.使用Session创建接口的代理对象；
        UserMapper userMapper=session.getMapper(UserMapper.class);
        //5.然后由代理对象执行方法；
        List<User> users=userMapper.findAll();
        for(User user: users){
            System.out.println(user);
        }
        //6.释放资源；
        session.close();
        in.close();


    }

}
