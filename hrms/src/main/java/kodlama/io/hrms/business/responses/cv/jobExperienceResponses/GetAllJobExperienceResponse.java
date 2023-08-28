package kodlama.io.hrms.business.responses.cv.jobExperienceResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobExperienceResponse {
	
	private String companyName;
	private String position;
	private LocalDate entranceDate;
	private LocalDate leavingDate;

}
