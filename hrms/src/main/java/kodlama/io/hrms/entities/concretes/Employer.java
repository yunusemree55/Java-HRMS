package kodlama.io.hrms.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import kodlama.io.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User{

	@Column(name="companyName")
	private String companyName;
	
	@Column(name="webSite")
	private String webSite;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	
	
	
}
