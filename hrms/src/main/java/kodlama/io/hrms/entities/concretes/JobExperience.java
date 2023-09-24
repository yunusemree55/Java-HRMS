package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jobExperiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="entranceDate")
	private LocalDate entranceDate;
	
	@Column(name="leavingDate")
	private LocalDate leavingDate;
	
	@ManyToOne
	@JoinColumn(name="jobSeekerId")
	private JobSeeker jobSeeker;

}
