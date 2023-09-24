package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.socialMediaRequests.AddSocialMediaRequest;
import kodlama.io.hrms.business.responses.socialMediaResponses.GetAllSocialMediaResponse;

public interface SocialMediaService {
	
	List<GetAllSocialMediaResponse> getAll();
	List<GetAllSocialMediaResponse> getSocialMediaByUserId(int id);
	void add(AddSocialMediaRequest addSocialMediaRequest);

}
