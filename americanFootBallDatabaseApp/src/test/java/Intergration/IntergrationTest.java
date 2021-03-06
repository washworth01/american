package Intergration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.catalina.mapper.Mapper;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.AmericanFootballSpringBootDatabaseAppApplication;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.exception.ResourceNotFoundException;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModel;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.Order;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.AmericanFootballSpringBootRepository;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AmericanFootballSpringBootDatabaseAppApplication.class})
@AutoConfigureMockMvc
public class IntergrationTest
{
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private AmericanFootballSpringBootRepository garageRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Before
	public void clearDB()
	{
		garageRepository.deleteAll();
	}
	
	ObjectMapper mapper = new ObjectMapper(); 
	
	@Test
	public void findingAndRetriveingaAllVehiclesFromDatabase() throws Exception
	{
		AmericanFootballSpringBootModel vehicle = new AmericanFootballSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100); 
		
		garageRepository.save(vehicle);
		mvc.perform(get("/api/vehicle")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].type", is("Car")));
	}

	@Test
	public void addAVehicleToDatabaseTest() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders.post("/api/vehicle/")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"type\" : \"Car\", \"regNumber\" : \"AH58 QXZ\", \"manufacturer\" : \"Honda\", \"make\" : \"Civic\", \"colour\" : \"Brown\", \"topSpeed\" : \"100\"}"))
			.andExpect(status()
			.isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.type", is("Car")));
	}
 
	@Test
	public void getAVehicleFromDatabaseByIdTest() throws Exception
	{
//		mvc.perform(MockMvcRequestBuilders.post("/api/vehicle")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content("{\"id\" :1, \"type\" : \"Car\", \"regNumber\" : \"AH58 QXZ\", \"manufacturer\" : \"Honda\", \"make\" : \"Civic\", \"colour\" : \"Brown\", \"topSpeed\" : \"100\"}"));
		
		AmericanFootballSpringBootModel vehicle = new AmericanFootballSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100); 
		
		garageRepository.save(vehicle);
		mvc.perform(MockMvcRequestBuilders.get("/api/vehicle/" + vehicle.getId())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.regNumber", is(("AH58 QXZ"))));
	}
	
	@Test
	public void getAVehicleFromDatabaseByTypeTest() throws Exception
	{
		AmericanFootballSpringBootModel vehicle = new AmericanFootballSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100); 
	
		garageRepository.save(vehicle);
		mvc.perform(MockMvcRequestBuilders.get("/api/vehicle/type/" + vehicle.getType())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].type", is(("Car"))));
	}	
 
//	@Test
//	public void getAVehicleFromDatabaseNotFoundExceptionTest()
//	{
//		GarageSpringBootModel vehicle = new GarageSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100); 
//		try
//		{
//			mvc.perform(get("/api/vehicle" + vehicle.getId())
//				.contentType(MediaType.APPLICATION_JSON));
//		}
//		catch(ResourceNotFoundException test)
//		{
//			assertEquals(("GarageSpringBootModel not found with id : " + vehicle.getId()), test.getMessage()); 
//		}
//		catch(Exception e)
//		{
//			
//		}
//	}

	@Test
	public void updateAVehicleFromDataBaseTest() throws Exception
	{
//		mvc.perform(MockMvcRequestBuilders.post("/api/vehicle")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content("{\"id\" :1, \"type\" : \"Car\", \"regNumber\" : \"AH58 QXZ\", \"manufacturer\" : \"Honda\", \"make\" : \"Civic\", \"colour\" : \"Brown\", \"topSpeed\" : \"100\"}"));

		AmericanFootballSpringBootModel vehicle = new AmericanFootballSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100); 
		AmericanFootballSpringBootModel vehicle1 = new AmericanFootballSpringBootModel("Van", "AH18 QXZ", "BMW", "Big", "Blue", 130); 

		
		garageRepository.save(vehicle);
		
		mvc.perform(MockMvcRequestBuilders.put("/api/vehicle/" + vehicle.getId())
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsString(vehicle1)))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.regNumber", is("AH18 QXZ")));
	}

	@Test
	public void deleteAVehicleFromDatabaseTest() throws Exception
	{
//		mvc.perform(MockMvcRequestBuilders.post("/api/vehicle")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content("{\"id\" :1,\"type\" : \"Car\", \"regNumber\" : \"AH58 QXZ\", \"manufacturer\" : \"Honda\", \"make\" : \"Civic\", \"colour\" : \"Brown\", \"topSpeed\" : \"100\"}"));

		AmericanFootballSpringBootModel vehicle = new AmericanFootballSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100); 

		garageRepository.save(vehicle);
	
		mvc.perform(MockMvcRequestBuilders.delete("/api/vehicle/" + vehicle.getId())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
		mvc.perform(MockMvcRequestBuilders.get("/api/vehicle/" + vehicle.getId())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}

	@Test
	public void resourceNotFoundExceptionTest() throws Exception
	{
		AmericanFootballSpringBootModel vehicle = new AmericanFootballSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100);
		
		try
		{
			throw new ResourceNotFoundException("GarageSpringBootModel", "id", vehicle.getId());
		}
		catch(ResourceNotFoundException test)
		{
			assertEquals(("GarageSpringBootModel not found with id : " + vehicle.getId()), test.getMessage()); 
		} 
	}
	
	@Test
	public void getOrdersTableFromDatabase() throws Exception
	{
		AmericanFootballSpringBootModel vehicle = new AmericanFootballSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100); 
		Order order = new Order("Super", "Cool", vehicle);
		
		garageRepository.save(vehicle);
		orderRepository.save(order);
		mvc.perform(get("/api/vehicle/" + vehicle.getId() + "/orders")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.content[0].id", is(1)))
			.andExpect(jsonPath("$.content[0].title", is("Super")))
			.andExpect(jsonPath("$.content[0].description", is("Cool")));
	}
	
//	@Test
//	public void addAnOrderToTheOrdersTableTest() throws Exception
//	{
//		GarageSpringBootModel vehicle = new GarageSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100); 
//		Order order = new Order("Super", "Cool", vehicle);
//		
//		garageRepository.save(vehicle);
//		
//		mvc.perform(MockMvcRequestBuilders.post("/api/vehicle/" + vehicle.getId() + "/orders")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(mapper.writeValueAsString(order)))
//			.andExpect(status().isOk())
//			.andExpect(content()
//			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//			.andExpect(jsonPath("$.id", is(4)));
//	}
//	
	@Test
	public void updateAnOrderFromTheOrderTableTest() throws Exception
	{
		AmericanFootballSpringBootModel vehicle = new AmericanFootballSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100);
		Order order = new Order("Super", "Cool", vehicle);
		Order order1 = new Order("Amazing", "Alright", vehicle);
		
		garageRepository.save(vehicle);
		orderRepository.save(order);
		mvc.perform(MockMvcRequestBuilders.put("/api/vehicle/" + vehicle.getId() + "/orders/" + order.getId())
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsString(order1)))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.title", is("Amazing")));			
	}
	
//	@Test
//	public void deleteAnOrderFromTheOrderTableTest() throws Exception
//	{
//		GarageSpringBootModel vehicle = new GarageSpringBootModel("Car", "AH58 QXZ", "Honda", "Civic", "Brown", 100);
//		Order order = new Order("Super", "Cool", vehicle);
//		
//		garageRepository.save(vehicle);
//		orderRepository.save(order);
//		
//		
//		mvc.perform(MockMvcRequestBuilders.delete("/api/vehicle/" + vehicle.getId() + "/orders/" + order.getId())
//			.contentType(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk());
//		
//		mvc.perform(MockMvcRequestBuilders.get("/api/vehicle/" + vehicle.getId() + "/orders")
//			.contentType(MediaType.APPLICATION_JSON))
//			.andExpect(status().isNotFound());
//	}
}

