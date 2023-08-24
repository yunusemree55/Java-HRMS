package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cityRequests.AddCityRequest;
import kodlama.io.hrms.business.responses.cityResponses.GetAllCityResponse;

public interface CityService {
	
	List<GetAllCityResponse> getAll();
	void add(AddCityRequest addCityRequest);

}
