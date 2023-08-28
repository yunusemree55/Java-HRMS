package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cv.AddCvRequest;
import kodlama.io.hrms.business.responses.cv.GetAllCvWithJobSeekerResponse;

public interface CvService {
	
	List<GetAllCvWithJobSeekerResponse> getAll();
	void add(AddCvRequest addCvRequest);

}
