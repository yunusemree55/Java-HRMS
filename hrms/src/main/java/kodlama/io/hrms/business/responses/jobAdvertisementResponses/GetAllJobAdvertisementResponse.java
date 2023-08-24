package kodlama.io.hrms.business.responses.jobAdvertisementResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobAdvertisementResponse {
	
	private String companyName;
	private String jobPositionName;
	private String description;
	private String cityName;
	private String statusName;
	private int numberOfPosition;
	private LocalDate endingDate;
	private LocalDate startingDate;
	
}
