package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.SocialMediaService;
import kodlama.io.hrms.business.requests.cv.socialMediaRequests.AddSocialMediaRequest;
import kodlama.io.hrms.business.responses.cv.socialMediaResponses.GetAllSocialMediaResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/socialmedias")
@AllArgsConstructor
public class SocialMediasController {
	
	private SocialMediaService socialMediaService;
	
	@GetMapping("/getall")
	public List<GetAllSocialMediaResponse> getAll(){
		
		return socialMediaService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddSocialMediaRequest addSocialMediaRequest) {
		
		socialMediaService.add(addSocialMediaRequest);
		
	}

}