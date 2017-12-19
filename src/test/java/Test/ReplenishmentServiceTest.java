package Test;

import com.work.entity.Role;
import com.work.entity.User;
import com.work.repository.ReplenishmentRepository;
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
public class ReplenishmentServiceTest {

    @Autowired
    private ReplenishmentRepository replenishmentRepository;



}
