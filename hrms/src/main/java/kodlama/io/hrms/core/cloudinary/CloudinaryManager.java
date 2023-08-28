package kodlama.io.hrms.core.cloudinary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryManager {
	

	@Bean
	public Cloudinary cloudinary() {
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "dsuxjcwe1",
				  "api_key", "138879455648579",
				  "api_secret", "4tGY6hj9yvH9pELX3j6EEXJH9lA"));
		
		
		
		return cloudinary;
		
		
		
	}
	

}
