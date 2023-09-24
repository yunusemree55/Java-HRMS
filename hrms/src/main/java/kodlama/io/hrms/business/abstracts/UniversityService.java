package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.universityRequests.AddUniversityRequest;
import kodlama.io.hrms.business.responses.universityResponses.GetAllUniversityResponse;

public interface UniversityService {
	
	List<GetAllUniversityResponse> getAll();
	void add(AddUniversityRequest addUniversityRequest);

}
