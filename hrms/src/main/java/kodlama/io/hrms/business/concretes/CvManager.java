package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.requests.cvRequests.AddCvRequest;
import kodlama.io.hrms.business.requests.cvRequests.UpdateCvRequest;
import kodlama.io.hrms.business.responses.cvResponses.GetAllCvWithJobSeekerResponse;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.CvRepository;
import kodlama.io.hrms.entities.concretes.cvs.Cv;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CvManager implements CvService {
	
	private CvRepository cvRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCvWithJobSeekerResponse> getAll() {
		List<GetAllCvWithJobSeekerResponse> cvResponseList = cvRepository.findAll().stream().map(cv -> modelMapperService.forResponse()
				.map(cv, GetAllCvWithJobSeekerResponse.class)).collect(Collectors.toList());
		
		return cvResponseList;
	}
	
	@Override
	public void add(AddCvRequest addCvRequest) {
		
		Cv cv = modelMapperService.forRequest().map(addCvRequest, Cv.class);	
		cv.setId(0);
		
		cvRepository.save(cv);
		
	}

	@Override
	public void update(UpdateCvRequest updateCvRequest) {
		
		Cv target = modelMapperService.forRequest().map(updateCvRequest, Cv.class);
		
		cvRepository.save(target);
		
	}
	

}
