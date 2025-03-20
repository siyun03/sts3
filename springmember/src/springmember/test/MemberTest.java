package springmember.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmember.controller.MemberController;
import springmember.model.Member;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmember/conf/applicationContext.xml")
public class MemberTest {
	
	@Autowired
	private MemberController memberController;
	
//	@Test
//	public void testSelectMember() {
//		List<Member> memberList = memberController.selectMember();
//		assertNotNull(memberList);
//		System.out.println(memberList);
//	}
//	
//	@Test
//	public void testUpdateMember() {
//	int result = memberController.updateMember(new Member("HONG","È«±æ¼ø",null,"ºÎ»ê"));
//		if( result >0) System.out.println("¼º°ø");
//	}
	
//	@Test
//	public void testDeleteMember() {
//		memberController.deleteMember("HONG");
//		int result = memberController.updateMember(new Member("HONG","È«±æ¼ø",null,"ºÎ»ê"));
//		if( result >0) System.out.println("¼º°ø");
//	}
//	
//	@Test
//	public void testInsertMember() {
//		memberController.insertMember(new Member("Èþ","Èþ","F","Èþ"));
//		int result = memberController.updateMember(new Member("HONG","È«±æ¼ø",null,"ºÎ»ê"));
//		if( result >0) System.out.println("¼º°ø");
//		
//	}
	
//	@Test
//	public void testGetMember() {
//		Member member = memberController.getMember("HONG");
//		System.out.println(member);
//		assertEquals("È«±æµ¿", member.getMname());
//	}
//	
	

}
