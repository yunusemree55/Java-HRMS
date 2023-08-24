package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.business.requests.cityRequests.AddCityRequest;
import kodlama.io.hrms.business.responses.cityResponses.GetAllCityResponse;
import kodlama.io.hrms.business.rules.CityBusinessRules;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.CityRepository;
import kodlama.io.hrms.entities.concretes.City;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityManager implements CityService{
	
	private CityRepository cityRepository;
	private ModelMapperService modelMapperService;
	private CityBusinessRules cityBusinessRules;
	
	@Override
	public List<GetAllCityResponse> getAll() {
		
		List<GetAllCityResponse> cityResponseList = cityRepository.findAll()
				.stream().map(city -> modelMapperService.forResponse().map(city, GetAllCityResponse.class))
				.collect(Collectors.toList());
		
		return cityResponseList;
		
	}
	

	@Override
	public void add(AddCityRequest addCityRequest) {
		
		cityBusinessRules.checkCityNameIfExists(addCityRequest.getName());
		
		City city = modelMapperService.forRequest().map(addCityRequest, City.class);
		
		cityRepository.save(city);
		
	}

	

}
