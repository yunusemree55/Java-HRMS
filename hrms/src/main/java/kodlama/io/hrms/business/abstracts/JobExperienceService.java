package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.jobExperienceRequests.AddJobExperienceRequest;
import kodlama.io.hrms.business.responses.jobExperienceResponses.GetAllJobExperienceResponse;

public interface JobExperienceService {
	
	List<GetAllJobExperienceResponse> getAll();
	List<GetAllJobExperienceResponse> getJobExperiencesByJobSeekerId(int id);
	void add(AddJobExperienceRequest addJobExperienceRequest);

}
