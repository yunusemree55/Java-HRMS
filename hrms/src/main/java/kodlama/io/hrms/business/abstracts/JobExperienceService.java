package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cv.jobExperienceRequests.AddJobExperienceRequest;
import kodlama.io.hrms.business.responses.cv.jobExperienceResponses.GetAllJobExperienceResponse;

public interface JobExperienceService {
	
	List<GetAllJobExperienceResponse> getAll();
	void add(AddJobExperienceRequest addJobExperienceRequest);

}
