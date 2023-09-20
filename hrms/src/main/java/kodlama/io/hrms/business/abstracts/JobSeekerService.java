package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.jobSeekerRequests.AddJobSeekerRequest;
import kodlama.io.hrms.business.responses.jobSeekerResponses.GetAllJobSeekerResponse;
import kodlama.io.hrms.business.responses.jobSeekerResponses.GetJobSeekerResponse;

public interface JobSeekerService {
	
	List<GetAllJobSeekerResponse> getAll();
	GetJobSeekerResponse getJobSeekerByEmail(String email);
	GetJobSeekerResponse getJobSeekerById(int id);
	void add(AddJobSeekerRequest addJobSeekerRequest);
	boolean existsByIdentityNumber(String identityNumber);
	boolean existsByEmail(String email);

}
