package kodlama.io.hrms.core.utilities.verifications;

public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public void sendEmail(String email) {
		
		System.out.println("Email doğrulaması için mail gönderildi: " + email);
		
	}

}
