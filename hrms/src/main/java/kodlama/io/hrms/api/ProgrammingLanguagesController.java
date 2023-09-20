package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.business.requests.cv.ProgrammingLanguageRequests.AddProgrammingLanguageRequest;
import kodlama.io.hrms.business.responses.cv.ProgrammingLanguageResponses.GetAllProgrammingLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/programminglanguages")
@AllArgsConstructor
@CrossOrigin
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	
	@GetMapping("/getall")
	private List<GetAllProgrammingLanguageResponse> getAll(){
		
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code= HttpStatus.CREATED)
	public void add(@RequestBody AddProgrammingLanguageRequest addProgrammingLanguageRequest) {
		
		programmingLanguageService.add(addProgrammingLanguageRequest);
	}
}
