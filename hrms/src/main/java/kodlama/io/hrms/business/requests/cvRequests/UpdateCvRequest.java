package kodlama.io.hrms.business.requests.cvRequests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCvRequest {

	private int id;
	private int jobSeekerId;
	@NotNull(message = "Açıklama alanı boş bırakılamaz")
	@Size(min = 30, message = "Açıklama alanı en az 30 karakter içermelidir")
	private String description;

}
