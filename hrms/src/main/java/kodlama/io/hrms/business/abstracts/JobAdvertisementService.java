package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.jobAdvertisementRequests.AddJobAdvertisementRequest;
import kodlama.io.hrms.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequest;
import kodlama.io.hrms.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponse;

public interface JobAdvertisementService {
	
	List<GetAllJobAdvertisementResponse> getAll();
	List<GetAllJobAdvertisementResponse> getActiveJobAdvertisements();
	List<GetAllJobAdvertisementResponse> getJobAdvertisementByEndingDate();
	List<GetAllJobAdvertisementResponse> getJobAdvertisementByCompanyName(String companyName);
	void add(AddJobAdvertisementRequest addJobAdvertisementRequest);
	void update(UpdateJobAdvertisementRequest jobAdvertisementRequest);
	void delete(int id);

}
