package Test;

import com.work.entity.Role;
import com.work.entity.User;
import com.work.repository.UserRepository;
import config.TestDataBaseConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest(){

        User user = new User();
        user.setEnabled(true);
        user.setBalance(1);
        user.setPassword("111");
        user.setRegistration(new Date());
        user.setUsername("Vova");
        user.setRole(Role.USER);

        userRepository.save(user);
        userRepository.save(user);

        Assert.assertEquals(user.getUsername(),userRepository.findByUserName("Vova").getUsername());

    }

    @Test
    public void updateBalance(){

        User user = new User();
        user.setEnabled(true);
        user.setBalance(1);
        user.setPassword("111");
        user.setRegistration(new Date());
        user.setUsername("Vova");
        user.setRole(Role.USER);

        userRepository.save(user);

        userRepository.setNewBalace(9.0,"Vova");

        Assert.assertEquals(java.util.Optional.ofNullable(10.0), java.util.Optional.ofNullable(userRepository.getBalanceByUser(user)));
    }

    @Test
    public void selectByRole(){

        User user = new User();
        user.setEnabled(true);
        user.setBalance(1);
        user.setPassword("111");
        user.setRegistration(new Date());
        user.setUsername("Vova");
        user.setRole(Role.USER);

        userRepository.save(user);

        Assert.assertEquals(user.getUsername(),userRepository.getAllUser(Role.USER).get(0).getUsername());
    }
}
