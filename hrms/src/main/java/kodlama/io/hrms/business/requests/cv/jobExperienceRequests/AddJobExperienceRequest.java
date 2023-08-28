package kodlama.io.hrms.business.requests.cv.jobExperienceRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobExperienceRequest {
	
	private String companyName;
	private String position;
	private LocalDate entranceDate;
	private LocalDate leavingDate;
	private int cvId;

}
