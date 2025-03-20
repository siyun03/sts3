package springmvc4.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc4.model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@GetMapping("/persons")
	@ResponseBody
	public List<Person> getPersonList() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("홍길동", 20));
		personList.add(new Person("강감찬", 30));
		personList.add(new Person("이순신", 40));
		System.out.println(personList);
		return personList;
	}
	
	@GetMapping("/persons/{pname}")
	@ResponseBody
	public Person getPerson(@PathVariable String pname) {
		System.out.println(pname);
		return new Person("홍길덩", 20);
	}
	
	@PostMapping(value="/persons", headers={"Content-type=application/json"})
	@ResponseBody
	public Person insertPerson(@RequestBody Person person) {
		System.out.println(person);
		return person;
	}
	
	@PutMapping(value="/persons/{pname}", headers={"Content-type=application/json"})
	@ResponseBody
	public Person updatePerson(@RequestBody Person person) {
		System.out.println(person);
		return person;
	}
	
	@PatchMapping(value="persons/{pname}", headers= {"Contetn-type=application/json"})
	@ResponseBody
	public Person partUpdatePerson(@RequestBody Person person) {
		System.out.println(person);
		return person;
	}
	
	@DeleteMapping("/persons/{pname}")
	@ResponseBody
	public Person deletePerson(@PathVariable String pname) {
		System.out.println(pname);
		return new Person("홍길동", 20);
	}
	
	
	
	
	
	
	

}
