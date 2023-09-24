package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.languageRequests.AddLanguageRequest;
import kodlama.io.hrms.business.responses.languageResponses.GetAllLanguageResponse;

public interface LanguageService {
	
	List<GetAllLanguageResponse> getAll();
	void add(AddLanguageRequest addLanguageRequest);

}
