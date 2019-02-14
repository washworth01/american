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
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelContactDetails;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelUser;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryContactDetails;
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
	
	private ObjectMapper mapper = new ObjectMapper(); 
	
	@Test
	public void findingAndRetriveingaAllUsersFromDatabase() throws Exception
	{		
		AmericanFootballSpringBootModelContactDetails contact1 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 24, "asda Road", "West Bridgford", "Nottingham",
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
			.andExpect(jsonPath("$[1].username", is("james")));
	} 

	@Test
	public void addAUserToDatabaseTest() throws Exception
	{
		AmericanFootballSpringBootModelContactDetails contact2 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 24, "Boundary Road", "West Bridgford", "Nottingham"
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
		AmericanFootballSpringBootModelContactDetails contact3 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 24, "asda Road", "West Bridgford", "Nottingham",
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
		AmericanFootballSpringBootModelContactDetails contact4 = new AmericanFootballSpringBootModelContactDetails("NG27BZ", 24, "asda Road", "West Bridgford", "Nottingham",
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
}
