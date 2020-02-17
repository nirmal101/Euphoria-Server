package lk.ac.cmb.ucsc.euphoria;

import lk.ac.cmb.ucsc.euphoria.model.User;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.service.CounselorService;
import lk.ac.cmb.ucsc.euphoria.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EuphoriaApplicationTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(CounselorService.class);

    @Autowired
    CounselorRepository counselorRepository;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
//        seedCounselorTestValues();
        seedUserTestValues();
    }

//    void seedCounselorTestValues() {
//        LoginCredentials loginCredentials = new LoginCredentials("testCounselor", "password", "testCounselor@euphoria.io");

////        Counselor counselor = new Counselor("TestCounselor", "This account is for testing",
////                "N/A", "N/A", "Colombo", "");

//        counselor.setLoginCredentials(loginCredentials);
//        counselorRepository.save(counselor);
//        LOGGER.debug("Successfully saved Test Counselor");
//    }

    void seedUserTestValues() {
        User user = new User("M", "TestUserFN", "TestUserLN", "testUser@euphoria.io",
                "password", 0112222222, "2020-02-17", "2020000000000",
                "Colombo", "Colombo", "formal");
        userService.formalSignUp(user);
        LOGGER.debug("Successfully saved Test User");
    }

}
