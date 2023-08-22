package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.jobSeekerRequests.AddJobSeekerRequest;
import kodlama.io.hrms.business.responses.jobSeekerResponses.GetAllJobSeekerResponse;

public interface JobSeekerService {
	
	List<GetAllJobSeekerResponse> getAll();
	void add(AddJobSeekerRequest addJobSeekerRequest);

}
