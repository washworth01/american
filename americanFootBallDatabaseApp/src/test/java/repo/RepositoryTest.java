package repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.AmericanFootballSpringBootDatabaseAppApplication;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelContactDetails;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelUser;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryUser;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AmericanFootballSpringBootDatabaseAppApplication.class})
@DataJpaTest
public class RepositoryTest
{
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private RepositoryUser userRepo;
	
	@Test
	public void retrieveByIdTest() throws ParseException
	{		
		AmericanFootballSpringBootModelContactDetails contact1 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 24, "Boundary Road", "West Bridgford", "Nottingham"
				, "Nottinghamshire", "07497610331");
		
		AmericanFootballSpringBootModelUser user1 = new AmericanFootballSpringBootModelUser("washworth01", "12414", "washworth01@gmail.com", "William", "Ashworth",
				"1997-02-02", "Short", contact1); 
		
		entityManager.persist(user1);
		entityManager.flush();
		assertTrue(userRepo.findById(user1.getUserid()).isPresent());
	}
	
}
