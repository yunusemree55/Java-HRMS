package kodlama.io.hrms.core.adapter;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CloudinaryManagerAdapter implements CloudinaryService {
	
	private Cloudinary cloudinary;

	@Override
	public String uploadFile(MultipartFile url) throws IOException {
		
		
		 return cloudinary.uploader().upload(url.getBytes(), ObjectUtils.asMap("resource_type", "auto")).get("url").toString();
		
	}
	
	
 
}
