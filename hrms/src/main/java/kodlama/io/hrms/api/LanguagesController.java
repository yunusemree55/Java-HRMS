package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.business.requests.cv.languageRequests.AddLanguageRequest;
import kodlama.io.hrms.business.responses.cv.languageResponses.GetAllLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {
	
	private LanguageService languageService;
	
	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() AddLanguageRequest addLanguageRequest) {
		
		languageService.add(addLanguageRequest);
	}
	 

}
