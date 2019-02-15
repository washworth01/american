package Intergration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.catalina.mapper.Mapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.AmericanFootballSpringBootDatabaseAppApplication;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.exception.ResourceNotFoundException;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelCoach;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelContactDetails;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelUser;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryCoach;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryContactDetails;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryPlayer;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryUser;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AmericanFootballSpringBootDatabaseAppApplication.class})
@AutoConfigureMockMvc
public class UserIntergrationTest
{
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private RepositoryUser userRepository;
	
	@Autowired
	private RepositoryContactDetails contactRepository;
	
	@Autowired
	private RepositoryPlayer playerRepository;
	
	@Autowired
	private RepositoryCoach coachRepository;
	
	@Before
	public void setup()
	{
		userRepository.deleteAll();
				contactRepository.deleteAll();
				playerRepository.deleteAll();
				coachRepository.deleteAll();
	}
	
	
	private ObjectMapper mapper = new ObjectMapper(); 
	
	@Test
	public void findingAndRetriveingaAllUsersFromDatabase() throws Exception
	{		
		AmericanFootballSpringBootModelContactDetails contact1 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 99, "asda Road", "West Bridgford", "Nottingham",
				"Nottinghamshire", "07497610331"); 
		
		AmericanFootballSpringBootModelUser user1 = new AmericanFootballSpringBootModelUser("james", "12414", "asdasda@gmail.com", "James", "Jordan",
				"1997-02-02", "Short", contact1);
		
		contactRepository.save(contact1);
		userRepository.save(user1);
		mvc.perform(MockMvcRequestBuilders.get("/api/user")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].username", is("james")));
	} 

	@Test
	public void addAUserToDatabaseTest() throws Exception
	{
		AmericanFootballSpringBootModelContactDetails contact2 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 76, "Boundary Road", "West Bridgford", "Nottingham"
				, "Nottinghamshire", "07497610331");
		AmericanFootballSpringBootModelUser user2 = new AmericanFootballSpringBootModelUser("washworth", "12414", "washworth01@gmail.com", "William", "Ashworth",
				"1997-02-02" , "Short", contact2);
		
		contactRepository.save(contact2);
		userRepository.save(user2);
		mvc.perform(post("/api/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsString(user2)))
			.andExpect(status()
			.isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.username", is("washworth")));
	}  
	
	@Test
	public void deleteAUserFromDatabaseTest() throws Exception
	{
		AmericanFootballSpringBootModelContactDetails contact3 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 53, "asda Road", "West Bridgford", "Nottingham",
				"Nottinghamshire", "07497610331"); 
		
		AmericanFootballSpringBootModelUser user3 = new AmericanFootballSpringBootModelUser("washworth01", "12414", "washworth01@gmail.com", "William", "Ashworth",
				"1997-02-02", "Short", contact3);
		
		contactRepository.save(contact3);
		userRepository.save(user3);
	
		mvc.perform(delete("/api/user/" + user3.getUserid())
			.contentType(MediaType.APPLICATION_JSON)) 
			.andExpect(status().isOk());
		
		mvc.perform(MockMvcRequestBuilders.get("/api/user/" + user3.getUserid())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void updateAUserFromDatabaseTest() throws Exception
	{
		AmericanFootballSpringBootModelContactDetails contact4 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 32, "asda Road", "West Bridgford", "Nottingham",
				"Nottinghamshire", "07497610331"); 
		
		contactRepository.save(contact4);
		
		AmericanFootballSpringBootModelUser user4 = new AmericanFootballSpringBootModelUser("JohnFrank", "12414", "Judas@gmail.com", "John", "Frank",
				"1974-12-30", contact4);
		
		userRepository.save(user4);
		mvc.perform(MockMvcRequestBuilders.put("/api/user/" + user4.getUserid())
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user4)))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.username", is("JohnFrank")));
	}
	
	@Test
	public void findingAndRetriveingaAllContactAddressFromDatabase() throws Exception
	{		
		AmericanFootballSpringBootModelContactDetails contact6 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 24, "asda Road", "West Bridgford", "Nottingham",
				"Nottinghamshire", "07497610331"); 
		
		contactRepository.save(contact6);
		mvc.perform(MockMvcRequestBuilders.get("/api/contact")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].houseNumber", is(24)));
	}
	
	@Test
	public void addAContactAddressToDatabaseTest() throws Exception
	{
		AmericanFootballSpringBootModelContactDetails contact7 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 783, "Boundary Road", "West Bridgford", "Nottingham"
				, "Nottinghamshire", "07497610331");
		
		contactRepository.save(contact7);
		mvc.perform(post("/api/contact")
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsString(contact7)))
			.andExpect(status()
			.isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.houseNumber", is(783)));
	} 
	
	@Test
	public void deleteAContactAddressFromDatabaseTest() throws Exception
	{
		AmericanFootballSpringBootModelContactDetails contact8 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 24, "asda Road", "West Bridgford", "Nottingham",
				"Nottinghamshire", "07497610331"); 
		
		contactRepository.save(contact8);	
		mvc.perform(delete("/api/contact/" + contact8.getContactDetailsId())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
		mvc.perform(MockMvcRequestBuilders.get("/api/contact/" + contact8.getPostcode() + "/" + contact8.getHouseNumber())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void updateAContactAddressrFromDatabaseTest() throws Exception
	{
		AmericanFootballSpringBootModelContactDetails contact9 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 100, "asda Road", "Nottingham",
				"Nottinghamshire", "07497610331"); 
		
		contactRepository.save(contact9);
		mvc.perform(MockMvcRequestBuilders.put("/api/contact/" + contact9.getContactDetailsId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(contact9)))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.houseNumber", is(100)));
	}
	
	@Test
	public void findingAndRetriveingaAllCoachesFromDatabase() throws Exception
	{		
		AmericanFootballSpringBootModelContactDetails contact10 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 99, "asda Road", "West Bridgford", "Nottingham",
				"Nottinghamshire", "07497610331"); 
		
		AmericanFootballSpringBootModelUser user5 = new AmericanFootballSpringBootModelUser("james", "12414", "asdasda@gmail.com", "James", "Jordan",
				"1997-02-02", "Short", contact10);
		
		AmericanFootballSpringBootModelCoach coach1 = new AmericanFootballSpringBootModelCoach("Defence", user5);
		
		userRepository.save(user5);
		contactRepository.save(contact10);
		coachRepository.save(coach1);
		mvc.perform(MockMvcRequestBuilders.get("/api/coach")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].trainingSpecialisation", is("Defence")));
	}
}
	
//	@Test
//	public void addAContactAddressToDatabaseTest() throws Exception
//	{
//		AmericanFootballSpringBootModelContactDetails contact7 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 783, "Boundary Road", "West Bridgford", "Nottingham"
//				, "Nottinghamshire", "07497610331");
//		
//		contactRepository.save(contact7);
//		mvc.perform(post("/api/contact")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(mapper.writeValueAsString(contact7)))
//			.andExpect(status()
//			.isOk())
//			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//			.andExpect(jsonPath("$.houseNumber", is(783)));
//	} 
//}
