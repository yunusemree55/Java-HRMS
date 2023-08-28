package kodlama.io.hrms.core.adapter;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

	String uploadFile(MultipartFile url) throws IOException;
	
}
