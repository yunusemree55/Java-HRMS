package kodlama.io.hrms.business.requests.cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCvRequest {
	
	private int jobSeekerId;
	private String description;

}
