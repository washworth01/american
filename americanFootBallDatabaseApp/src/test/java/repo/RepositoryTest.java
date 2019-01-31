package repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.AmericanFootballSpringBootDatabaseAppApplication;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModel;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.AmericanFootballSpringBootRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AmericanFootballSpringBootDatabaseAppApplication.class})
@DataJpaTest
public class RepositoryTest
{
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AmericanFootballSpringBootRepository garageRepo;
	
	@Test
	public void retrieveByIdTest()
	{
		AmericanFootballSpringBootModel model1 = new AmericanFootballSpringBootModel("Car","AH58 QXZ","Honda","Civic","Brown",100);
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(garageRepo.findById(model1.getId()).isPresent());
	}
	
	@Test
	public void findByType()
	{
		List<AmericanFootballSpringBootModel> vehicles;
		AmericanFootballSpringBootModel model2 = new AmericanFootballSpringBootModel("Car","AH58 QXZ","Honda","Civic","Brown",100);
		entityManager.persist(model2);
		entityManager.flush();
		vehicles = garageRepo.findByType("Car");
		for(AmericanFootballSpringBootModel g : vehicles)
		{
			assertEquals(g.getType(), "Car");
		}
		
	}
}
