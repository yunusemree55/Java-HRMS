package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.statusRequests.AddStatusRequest;
import kodlama.io.hrms.business.responses.statusResponses.GetAllStatusResponse;

public interface StatusService {
	
	List<GetAllStatusResponse> getAll();
	void add(AddStatusRequest addStatusRequest);

}
