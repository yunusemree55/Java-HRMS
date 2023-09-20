package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.photoRequests.AddPhotoRequest;
import kodlama.io.hrms.business.requests.photoRequests.UpdatePhotoRequest;
import kodlama.io.hrms.business.responses.photoResponses.GetAllPhotoResponse;

public interface PhotoService {
	
	List<GetAllPhotoResponse> getAll();
	GetAllPhotoResponse getPhotoByUserId(int id);
	void add(AddPhotoRequest addPhotoRequest);
	void update(UpdatePhotoRequest updatePhotoRequest);

}
