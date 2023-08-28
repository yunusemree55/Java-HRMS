package kodlama.io.hrms.business.requests.cv;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCvRequest {
	
	private int jobSeekerId;
	private String description;
	private int universityId;
	private LocalDate entranceDate;
	private LocalDate graduationDate;
	private int departmentId;

}
