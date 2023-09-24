package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.programmingLanguageRequests.AddProgrammingLanguageRequest;
import kodlama.io.hrms.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	
	List<GetAllProgrammingLanguageResponse> getAll();
	void add(AddProgrammingLanguageRequest addProgrammingLanguageRequest);

}
