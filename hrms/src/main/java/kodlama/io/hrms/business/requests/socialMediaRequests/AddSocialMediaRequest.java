package kodlama.io.hrms.business.requests.socialMediaRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSocialMediaRequest {
	
	
	private String url;
	private int userId;

	
}
