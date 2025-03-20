package springjunit.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springjunit.model.Hobby;
import springjunit.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springjunit/conf/applicationContext.xml")
public class PersonTest {
	
	@Autowired
	private ApplicationContext context;
	
	@BeforeClass
	// �׽�Ʈ ����� ���� ���� �ѹ��� ����
	public static void beforClass() {
		System.out.println("BeforeClass~@");
	}
	
	@Before
	// @Test (�׽�Ʈ�޼ҵ�) �������� ����
	public void before() {
		System.out.println("Beforeeee");
	}
	
	@Test
	public void test1() {
		
		Person hong = context.getBean("person", Person.class);
		// value.properties������ hongŰ�� �ش��ϴ� ȫ�浿
		System.out.println(hong.getName());
		
		System.out.println("Test1");
		
		// hobby ��ü �����ؼ� sort������Ƽ�� '�౸' ����
		Hobby hobby = (Hobby)context.getBean("hobby");
		//Hobby hobby = context.getBean("hobby", Hobby.class);
		hobby.setSort("�౸");
		
		// ���� ������ �׽�Ʈ
		assertEquals("�౸", hobby.getSort()); // Success
		
	}
	
	@Test
	public void test2() {
		System.out.println("Test22");
		
		int[] iArr1 = {1, 2, 3};
		int[] iArr2 = {1, 3, 5};
		
		// �� �迭�� ���� ������ �׽�Ʈ
		assertArrayEquals(iArr1, iArr2);
	}
	
	@Test
	public void test3() {
		System.out.println("Test333");
		
		Person person1 = context.getBean("person", Person.class);
		Person person2 = context.getBean("person", Person.class);
		
		// ������ ������ = ���� ��ü���� �׽�Ʈ
		// �������� �⺻������ ��� ��ü�� �̱������� ���� -> ��ü�� �ϳ��� ����
		assertSame(person1, person2); // Success
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());
		
		person1.setName("ȫ�浢");
		
		System.out.println(person2.getName());
		System.out.println(person2.getAge());
		
	}
	
	@Test
	public void test4() {
		
		System.out.println("Test4444");
		boolean bool = true;
		
		// true���� �׽�Ʈ
		assertTrue(bool);
		
		Object obj = null;
		
		// null�� �ƴ��� �׽�Ʈ
		assertNotNull(obj);
		
	}
	
	@After
	// @Test (�׽�Ʈ�޼ҵ�) �����Ŀ� ����
	public void after() {
		System.out.println("After!");
	}
	
	@AfterClass
	// �׽�Ʈ�� �������� �ѹ��� ����
	public static void afterClass() {
		System.out.println("AfterClass!~");
	}

}
