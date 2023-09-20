package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SocialMediaService;
import kodlama.io.hrms.business.requests.cv.socialMediaRequests.AddSocialMediaRequest;
import kodlama.io.hrms.business.responses.cv.socialMediaResponses.GetAllSocialMediaResponse;
import kodlama.io.hrms.business.rules.SocialMediaBusinessRules;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.SocialMediaRepository;
import kodlama.io.hrms.entities.concretes.SocialMedia;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SocialMediaManager implements SocialMediaService {
	
	private SocialMediaRepository socialMediaRepository;
	private ModelMapperService modelMapperService;
	private SocialMediaBusinessRules socialMediaBusinessRules;
	
	@Override
	public List<GetAllSocialMediaResponse> getAll() {
		
		List<GetAllSocialMediaResponse> socialMediaResponseList = socialMediaRepository.findAll().stream().map(socialMedia-> 
		modelMapperService.forResponse().map(socialMedia, GetAllSocialMediaResponse.class)).collect(Collectors.toList());
		
		return socialMediaResponseList;
	}
	
	@Override
	public List<GetAllSocialMediaResponse> getSocialMediaByUserId(int id) {
		
		List<GetAllSocialMediaResponse> socialMediaResponseList = socialMediaRepository.getSocialMediaByUserId(id).stream()
				.map(socialMedia -> modelMapperService.forResponse().map(socialMedia, GetAllSocialMediaResponse.class))
				.collect(Collectors.toList());
		
		return socialMediaResponseList;
	}
	
	@Override
	public void add(AddSocialMediaRequest addSocialMediaRequest) {
		
		socialMediaBusinessRules.checkWebSite(addSocialMediaRequest.getUrl());
		
		SocialMedia socialMedia = modelMapperService.forRequest().map(addSocialMediaRequest, SocialMedia.class);
		socialMedia.setId(0);
		
		socialMediaRepository.save(socialMedia);
		
	}

	
	
	
	

}
