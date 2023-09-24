package kodlama.io.hrms.business.requests.languageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLanguageRequest {
	
	private String name;
	private int level;
	private int jobSeekerId;
	

}
