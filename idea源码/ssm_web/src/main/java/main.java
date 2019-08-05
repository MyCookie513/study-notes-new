
import com.dao.UserMapper;
import com.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
 public  class main {

    @Autowired()
    private UserMapper userMapper;


    @Test()
    public void demo() {

        List<User> users = userMapper.login("admin");
        for(User u: users){
            System.out.println(u);
        }
    }
}
