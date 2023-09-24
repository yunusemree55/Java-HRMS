package kodlama.io.hrms.business.responses.jobAdvertisementResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobAdvertisementResponse {
	
	private int id;
	private int employerId;
	private String photoUrl;
	private String companyName;
	private String employerEmail;
	private String employerWebsite;
	private String minSalary;
	private String maxSalary;
	private String jobPositionName;
	private String description;
	private String cityName;
	private int statusId;
	private int numberOfPosition;
	private LocalDate endingDate;
	private LocalDate startingDate;
	
}
