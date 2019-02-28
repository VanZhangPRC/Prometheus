package kraken.pheidippides.web.controller;

import kraken.pandora.repository.UserRepository;
import kraken.pandora.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class CanJPADoThis {

    @Autowired
    private UserService userService;

    @Test
    public void testDeleteBy() {
//        userService.deleteById(8);
//        userService.deleteByName("张建伟");
        userService.deleteByOrgId(39);
    }

}
