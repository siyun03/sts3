package springaopex.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springaopex.model.Springaopex;
import springaopex.service.SpringaopexService;
import springaopex.service.SpringaopexServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springaopex/conf/applicationContext.xml")
public class SpringTest {
	
	@Autowired
	private SpringaopexService springaopexService;

	
	//@Test
	@Ignore
	public void testSelectSpring() {
		List<Springaopex> SpringList = springaopexService.selectSpringaopex();
		assertNotNull(SpringList);
	}

	//@Test
	@Ignore
	public void testGetSpring() {
		Springaopex springaopex = springaopexService.getSpringaopex(1);
		assertNotNull(springaopex);
	}

	@Test
	//@Ignore
	public void testUpdateSpring() {
		int result = springaopexService.updateSpringaopex(new Springaopex(21, "비밀번호"));
		assertNotEquals(0, result);
	}
	
	//@Test
	@Ignore
	public void testDeleteSpring() {
		int result = springaopexService.deleteSpringaopex(1);
		assertNotEquals(0, result);
	}
	
	//@Test
	@Ignore
	public void testInsertSpring() {
	    int result = springaopexService.insertSpringaopex(new Springaopex(0, "비밀방고우"));
	    assertNotEquals(0, result);
	}

	
	
}
