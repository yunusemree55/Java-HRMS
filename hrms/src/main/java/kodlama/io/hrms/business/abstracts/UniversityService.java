package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cv.universityRequests.AddUniversityRequest;
import kodlama.io.hrms.business.responses.cv.universityResponses.GetAllUniversityResponse;

public interface UniversityService {
	
	List<GetAllUniversityResponse> getAll();
	void add(AddUniversityRequest addUniversityRequest);

}
