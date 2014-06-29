import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dataart.project.repositories.Arrangement;
import com.dataart.project.repositories.ArrangementRepository;
import com.dataart.project.services.ArrangementService;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext.xml" }, loader = ContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ArrangementRepositoryTest1 {

	@Autowired
	ArrangementService repository;

	@Test
	public void testcreateArrangement() {
		System.out.println(repository);
		repository.createArrangement(new Arrangement(3, "match", new
		Date()));
		List<Arrangement> real=repository.getArrangements();
		List<Arrangement> list = new ArrayList<Arrangement>() {{
		    add(new Arrangement(3, "match", new
		    		Date()));
		}};
		System.out.println(real.get(0).getName().toString());
		//assertEquals(list,real);

	}

}