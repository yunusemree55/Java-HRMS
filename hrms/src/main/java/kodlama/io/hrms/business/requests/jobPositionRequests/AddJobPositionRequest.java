package kodlama.io.hrms.business.requests.jobPositionRequests;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobPositionRequest {
	
	@Size(min = 3,message = "İş pozisyonu en az 3 karakter uzunluğunda olmalı")
	private String name;

}
