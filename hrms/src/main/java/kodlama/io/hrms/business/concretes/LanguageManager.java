package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.business.requests.languageRequests.AddLanguageRequest;
import kodlama.io.hrms.business.responses.languageResponses.GetAllLanguageResponse;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.LanguageRepository;
import kodlama.io.hrms.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllLanguageResponse> getAll() {
		
		List<GetAllLanguageResponse> languageResponseList = languageRepository.findAll().stream().map(language->
		modelMapperService.forResponse().map(language,GetAllLanguageResponse.class)).collect(Collectors.toList());
		
		return languageResponseList;
		
		
	}
	@Override
	public void add(AddLanguageRequest addLanguageRequest) {
		
		Language language = modelMapperService.forRequest().map(addLanguageRequest, Language.class);
		
		language.setId(0);
		
		
		languageRepository.save(language);
		
	}
	
	
	
}
