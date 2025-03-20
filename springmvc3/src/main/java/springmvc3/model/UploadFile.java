package springmvc3.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile implements Serializable {
	
	private static final long serialVersionUID = 90371298371L;
	
	private String title;
	private MultipartFile uploadFile;
	
	public UploadFile() {

	}
	
	public UploadFile(String title, MultipartFile uploadFile) {
		super();
		this.title = title;
		this.uploadFile = uploadFile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "UploadFile [title=" + title + ", uploadFile=" + uploadFile + "]";
	}
	
}
