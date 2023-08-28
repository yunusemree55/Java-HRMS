package kodlama.io.hrms.business.requests.cv.languageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLanguageRequest {
	
	private String name;
	private String level;
	private int cvId;
	

}
