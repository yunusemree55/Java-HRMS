package kodlama.io.hrms.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.dataAccess.abstracts.SocialMediaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SocialMediaBusinessRules extends EntityBusinessRules{
	
	private SocialMediaRepository socialMediaRepository;
	


}
