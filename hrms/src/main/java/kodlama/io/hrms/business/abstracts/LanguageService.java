package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cv.languageRequests.AddLanguageRequest;
import kodlama.io.hrms.business.responses.cv.languageResponses.GetAllLanguageResponse;

public interface LanguageService {
	
	List<GetAllLanguageResponse> getAll();
	void add(AddLanguageRequest addLanguageRequest);

}
