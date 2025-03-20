package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jdbcboard.dao.FileDAO;
import jdbcboard.model.AttachFile;
import jdbcboard.util.SqlMapUtil;

@Repository
public class FileDAOImpl implements FileDAO{

	private static FileDAOImpl fileDAOImpl = new FileDAOImpl();
	
	public FileDAOImpl() {

	}
	
	public static FileDAOImpl getFileDAOImpl() {
		return fileDAOImpl;
	}
	
	@Override
	public List<AttachFile> selectAttachFile(int aid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		List<AttachFile> attachFileList = sqlSession.selectList("attachfile.selectAttachFile", aid);
		sqlSession.close();
		return attachFileList;
	}
	
	@Override
	public AttachFile getAttachFile(int afid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		AttachFile attachFile = sqlSession.selectOne("attachfile.getAttachFile", afid);
		sqlSession.commit();
		sqlSession.close();
		return attachFile;
	}
	
	@Override
	public int insertAttachFile(AttachFile attachFile) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.insert("attachfile.insertAttachFile", attachFile);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	@Override
	public int deleteAttachFile(int afid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.delete("attachfile.deleteAttachFile", afid);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
}
