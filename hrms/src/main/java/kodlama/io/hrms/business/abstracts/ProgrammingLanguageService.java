package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cv.ProgrammingLanguageRequests.AddProgrammingLanguageRequest;
import kodlama.io.hrms.business.responses.cv.ProgrammingLanguageResponses.GetAllProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	
	List<GetAllProgrammingLanguageResponse> getAll();
	void add(AddProgrammingLanguageRequest addProgrammingLanguageRequest);

}
