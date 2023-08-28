package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.requests.cv.AddCvRequest;
import kodlama.io.hrms.business.responses.cv.GetAllCvWithJobSeekerResponse;
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
		
		cvRepository.save(cv);
		
	}
	

}
