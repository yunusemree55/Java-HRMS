package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UniversityService;
import kodlama.io.hrms.business.requests.cv.universityRequests.AddUniversityRequest;
import kodlama.io.hrms.business.responses.cv.universityResponses.GetAllUniversityResponse;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.UniversityRepository;
import kodlama.io.hrms.entities.concretes.cvs.University;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UniversityManager implements UniversityService {
	
	private UniversityRepository universityRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllUniversityResponse> getAll() {
		List<GetAllUniversityResponse> universityResponseList = universityRepository.findAll().stream().map(university ->
		modelMapperService.forResponse().map(university, GetAllUniversityResponse.class)).collect(Collectors.toList());
		
		return universityResponseList;
	}
	
	@Override
	public void add(AddUniversityRequest addUniversityRequest) {
		
		University university = modelMapperService.forRequest().map(addUniversityRequest, University.class);
		
		universityRepository.save(university);
		
		
	}

}
