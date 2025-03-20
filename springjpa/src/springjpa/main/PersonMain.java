package springjpa.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springjpa.model.Person;
import springjpa.service.PersonService;

public class PersonMain {

	private static PersonService personService;
	
	private static ApplicationContext context = new GenericXmlApplicationContext("classpath:/springjpa/conf/applicationContext.xml");
	
	public static void main(String[] args) {
		
		personService = (PersonService)context.getBean("personService", PersonService.class);
		
		// insert
//		Person person = new Person(0, "홍길동", 20, new Timestamp(System.currentTimeMillis()));
//		personService.insertPerson(person);
//		person = new Person(0, "강감찬", 30, new Timestamp(System.currentTimeMillis()));
//		personService.insertPerson(person);
		
		// getPersonList
//		List<Person> personList = personService.getPersonList();
//		for(Person eachperson : personList) {
//			System.out.println(eachperson);
//		}
		
		// getPerson
//		Person hong = personService.getPerson(5);
//		System.out.println(hong);
		
		// updatePerson
		Person updatePerson = new Person(1, "홍길덩", 30, new Date());
		int result = personService.updatePerson(updatePerson);
		if(result>0) System.out.println("수정왕료~");
		
		// deletePerson
//		int result = personService.deletePerson(4);
//		if(result >0) System.out.println("삭제 완!");
		
		
	} // main
	
}
