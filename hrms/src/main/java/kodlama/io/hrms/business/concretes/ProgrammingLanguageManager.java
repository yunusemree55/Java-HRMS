package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.business.requests.programmingLanguageRequests.AddProgrammingLanguageRequest;
import kodlama.io.hrms.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		
		List<GetAllProgrammingLanguageResponse> programmingLanguageResponseList = programmingLanguageRepository.findAll().stream()
				.map(programmingLanguage -> modelMapperService.forResponse()
				.map(programmingLanguage, GetAllProgrammingLanguageResponse.class)).collect(Collectors.toList());
		
		
		
		return programmingLanguageResponseList;
	}
	
	@Override
	public void add(AddProgrammingLanguageRequest addProgrammingLanguageRequest) {
		
		ProgrammingLanguage programmingLanguage = modelMapperService.forRequest()
				.map(addProgrammingLanguageRequest, ProgrammingLanguage.class);
		
		programmingLanguage.setId(0);
		
		programmingLanguageRepository.save(programmingLanguage);
		
	}
	

}
