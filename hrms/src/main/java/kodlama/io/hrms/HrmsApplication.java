package kodlama.io.hrms;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.hrms.core.exceptions.BusinessException;
import kodlama.io.hrms.core.exceptions.ProblemDetail;
import kodlama.io.hrms.core.exceptions.ValidationProblemDetail;

@SpringBootApplication
@RestControllerAdvice
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail handleBusinessException(BusinessException businessException) {
		ProblemDetail problemDetail = new ProblemDetail();
		
		problemDetail.setMessage(businessException.getMessage());

		return problemDetail;
	}
	
	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetail handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationProblemDetail validationProblemDetail = new ValidationProblemDetail();
		validationProblemDetail.setProblems(new HashMap<String, String>());
		validationProblemDetail.setMessage("Validasyon Hatası meydana geldi");
		
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			
			validationProblemDetail.getProblems().put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		return validationProblemDetail;
		
		
		
	}

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	 
}
   