package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jdbcboard.dao.MemberDAO;
import jdbcboard.model.Member;
import jdbcboard.util.BCryptUtil;
import jdbcboard.util.SqlMapUtil;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
	
	private MemberDAOImpl() {
	}
	
	public static MemberDAOImpl getMemberDAOImpl() {
		return memberDAOImpl;
	}
	
	@Override
	public List<Member> selectMember() {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		List<Member> memberList = sqlSession.selectList("member.selectMember");
		sqlSession.close();
		return memberList;
	}
	
	@Override
	public Member getMember(String mid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		Member member = sqlSession.selectOne("member.getMember", mid);
		sqlSession.close();		
		return member;
	}
	
	@Override
	public int insertMember(Member member) {
		member.setMpass(BCryptUtil.hashPassword(member.getMpass()));
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.insert("member.insertMember", member);
		sqlSession.commit();
		sqlSession.close();		
		return result;
	}
	
	@Override
	public int updateMember(Member member) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.update("member.updateMember", member);
		sqlSession.commit();		
		sqlSession.close();		
		return result;
	}
	
	@Override
	public int deleteMember(String mid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.delete("member.deleteMember", mid);
		sqlSession.commit();
		sqlSession.close();		
		return result;
	}
	
	@Override
	public boolean checkLogin(String mid, String mpass) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		String dbMpass = sqlSession.selectOne("member.selectMpass", mid);
		sqlSession.commit();
		sqlSession.close();				
		return BCryptUtil.checkPassword(mpass, dbMpass);
	}

}








