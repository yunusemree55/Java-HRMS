package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.photoRequests.AddPhotoRequest;
import kodlama.io.hrms.business.responses.photoResponses.GetAllPhotoResponse;

public interface PhotoService {
	
	List<GetAllPhotoResponse> getAll();
	void add(AddPhotoRequest addPhotoRequest);

}
