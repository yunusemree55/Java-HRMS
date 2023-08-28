package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cv.socialMediaRequests.AddSocialMediaRequest;
import kodlama.io.hrms.business.responses.cv.socialMediaResponses.GetAllSocialMediaResponse;

public interface SocialMediaService {
	
	List<GetAllSocialMediaResponse> getAll();
	void add(AddSocialMediaRequest addSocialMediaRequest);

}
