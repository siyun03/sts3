package jdbcboard.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbcboard.dao.FileDAO;
import jdbcboard.model.AttachFile;
import jdbcboard.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	FileDAO fileDao;
	
	@Override
	public List<AttachFile> selectAttachFile(int aid) {
		return fileDao.selectAttachFile(aid);
	}
	
	@Override
	public AttachFile getAttachFile(int afid) {
		return fileDao.getAttachFile(afid);
	}
	
	@Override
	public int insertAttachFile(AttachFile attachFile) {
		return fileDao.insertAttachFile(attachFile);
	}
	
	@Override
	public int deleteAttachFile(int afid) {
		return fileDao.deleteAttachFile(afid);
	}

}
