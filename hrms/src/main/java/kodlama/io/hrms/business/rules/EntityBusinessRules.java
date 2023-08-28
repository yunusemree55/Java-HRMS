package kodlama.io.hrms.business.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kodlama.io.hrms.core.exceptions.BusinessException;

public class EntityBusinessRules {
	
	
	public void checkWebSite(String webSite) {
		
		Pattern pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
		Matcher matcher = pattern.matcher(webSite);
		
		if(matcher.matches() == false) {
			throw new BusinessException("Web Sitesini doğru biçimde giriniz");
		}
		
	}

}
