package kodlama.io.hrms.business.requests.photoRequests;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePhotoRequest {
	
	private MultipartFile url;
	private int userId;

}
