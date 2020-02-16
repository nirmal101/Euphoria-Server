package lk.ac.cmb.ucsc.euphoria;

import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.service.CounselorService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EuphoriaApplicationTests {
	private static final Logger LOGGER= LoggerFactory.getLogger(CounselorService.class);

	@Autowired
	CounselorRepository counselorRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void seedTestValues(){
		LoginCredentials loginCredentials=new LoginCredentials("testCounselor","password","testCounselor@euphoria.io");
		Counselor counselor=new Counselor("TestCounselor","This account is for testing","N/A","N/A","Colombo","");
		counselor.setLoginCredentials(loginCredentials);
		counselorRepository.save(counselor);

		LOGGER.debug("Successfully saved Test Counselor");
	}

}
