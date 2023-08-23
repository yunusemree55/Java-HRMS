package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.jobPositionRequests.AddJobPositionRequest;
import kodlama.io.hrms.business.responses.jobPositionResponses.GetAllJobPositionResponse;

public interface JobPositionService {
	
	List<GetAllJobPositionResponse> getAll();
	void add(AddJobPositionRequest addJobPositionRequest);
}
