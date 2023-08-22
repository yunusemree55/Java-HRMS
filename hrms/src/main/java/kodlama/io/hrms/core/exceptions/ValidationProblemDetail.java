package kodlama.io.hrms.core.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetail extends ProblemDetail {
	
	private Map<String, String> problems;

}
