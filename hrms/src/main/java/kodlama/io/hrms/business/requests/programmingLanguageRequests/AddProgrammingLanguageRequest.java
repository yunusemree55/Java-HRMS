package kodlama.io.hrms.business.requests.programmingLanguageRequests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProgrammingLanguageRequest {
	
	@Size(max=15,message = "Maksimum 15 karakter içermelidir")
	@NotNull(message = "Programlama dili alanı boş bırakılamaz")
	private String name;
	
	private int jobSeekerId;

}
