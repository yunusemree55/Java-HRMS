package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cvRequests.AddCvRequest;
import kodlama.io.hrms.business.requests.cvRequests.UpdateCvRequest;
import kodlama.io.hrms.business.responses.cvResponses.GetAllCvWithJobSeekerResponse;

public interface CvService {
	
	List<GetAllCvWithJobSeekerResponse> getAll();
	void add(AddCvRequest addCvRequest);
	void update(UpdateCvRequest updateCvRequest);

}
