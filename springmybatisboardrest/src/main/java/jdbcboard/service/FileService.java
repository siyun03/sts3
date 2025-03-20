package jdbcboard.service;

import java.util.List;

import jdbcboard.model.AttachFile;

public interface FileService {
	
	public abstract List<AttachFile> selectAttachFile(int aid);
	
	public abstract AttachFile getAttachFile(int afid);
	
	public abstract int insertAttachFile(AttachFile attachFile);
	
	public abstract int deleteAttachFile(int afid);

}
