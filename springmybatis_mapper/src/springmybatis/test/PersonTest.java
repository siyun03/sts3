package springmybatis.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmybatis.model.Person;
import springmybatis.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmybatis/conf/applicationContext.xml")
public class PersonTest {
	
	@Autowired
	private PersonService personService;

	// insert
	//@Test
	@Ignore
	public void insertPerson() throws Throwable {
		int result = personService.insertPerson(new Person(0, "금요일군", 30));
		assertNotEquals(0, result);
	}
	
	 // get
	@Test
	//@Ignore
	 public void getPerson() throws Throwable {
		 Person person = personService.getPerson(1);
		 assertNotNull(person);
	 }
	 
	 // list
	//@Test
	@Ignore
	 public void getPersonList() throws Throwable {
		 List<Person> personList = personService.getPersonList();
		 assertNotEquals(0, personList.size());
	 }
	 
	// update
	//@Test
	@Ignore
	public void updatePerson() throws Throwable {
		int result = personService.updatePerson(new Person(3, "김길동", 40));
		assertNotEquals(0, result);
	}
	
	// delete 
	//@Test
	@Ignore
	public void deletePerson() throws Throwable {
		int result = personService.deletePerson(3);
		assertNotEquals(0, result);
	}

}
