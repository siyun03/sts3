package springmember.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmember.model.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Member> selectMember(){
		String sql = " select * from springmember ";
		return jdbcTemplate.query(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
							rs.getString("mid"),
							rs.getString("mname"),
							rs.getString("mgender"),
							rs.getString("mcity")
						);
				return member;
			}
		});
	}
		
	@Override
	public int updateMember(Member member) {
		StringBuffer updateQuery = new StringBuffer();
		updateQuery.append("update springmember set ");
		updateQuery.append("mname=?, mcity=? ");
		updateQuery.append("where mid=?");
		
		int result = this.jdbcTemplate.update(updateQuery.toString(),
				member.getMname(), member.getMcity(), member.getMid());
		return result;
	}

	@Override
	public int deleteMember(String mid) {
		StringBuffer deleteQuery = new StringBuffer();
		deleteQuery.append(" delete springmember ");
		deleteQuery.append(" where mid=? ");
		
		int result = this.jdbcTemplate.update(deleteQuery.toString(),mid);
		return result;
	}

	@Override
	public int insertMember(Member member) {
		StringBuffer insertQuery = new StringBuffer();
		insertQuery.append(" insert into springmember ");
		insertQuery.append(" values(?, ?, ?, ?) ");
		
		int result = this.jdbcTemplate.update(insertQuery.toString(),
				member.getMid(), member.getMname(), member.getMgender(), member.getMcity());
		return result;
	}


	
	@Override
	public Member getMember(String mid) {
		String sql = " select * from springmember where mid=? ";
		return this.jdbcTemplate.queryForObject(sql, new Object[] {mid}, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("mid"),
						rs.getString("mname"),
						rs.getString("mgender"),
						rs.getString("mcity")
					);
			return member;
			}
		});
	}
	
	
}
