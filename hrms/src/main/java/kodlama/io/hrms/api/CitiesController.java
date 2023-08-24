package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.business.requests.cityRequests.AddCityRequest;
import kodlama.io.hrms.business.responses.cityResponses.GetAllCityResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CitiesController {
	
	private CityService cityService;
	
	@GetMapping
	public List<GetAllCityResponse> getAll(){
		
		return cityService.getAll();
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(AddCityRequest addCityRequest) {
		
		cityService.add(addCityRequest);
		
	}

}
