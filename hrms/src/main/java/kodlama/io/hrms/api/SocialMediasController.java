package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.SocialMediaService;
import kodlama.io.hrms.business.requests.socialMediaRequests.AddSocialMediaRequest;
import kodlama.io.hrms.business.responses.socialMediaResponses.GetAllSocialMediaResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/socialmedias")
@AllArgsConstructor
@CrossOrigin
public class SocialMediasController {
	
	private SocialMediaService socialMediaService;
	
	@GetMapping("/getall")
	public List<GetAllSocialMediaResponse> getAll(){
		
		return socialMediaService.getAll();
	}
	
	@GetMapping("/getsocialmediabyuserid/{id}")
	public List<GetAllSocialMediaResponse> getSocialMediaByUserId(@PathVariable int id){
		
		return socialMediaService.getSocialMediaByUserId(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddSocialMediaRequest addSocialMediaRequest) {
		
		socialMediaService.add(addSocialMediaRequest);
		
	}

}
