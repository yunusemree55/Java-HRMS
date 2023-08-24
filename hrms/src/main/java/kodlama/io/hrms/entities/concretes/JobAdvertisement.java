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
@Table(name = "jobAdvertisements")
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="minSalary")
	private String minSalary;
	
	@Column(name="maxSalary")
	private String maxSalary;

	@Column(name="numberOfPosition")
	private int numberOfPosition;
	
	@Column(name="startingDate")
	private LocalDate startingDate;
	
	@Column(name="endingDate")
	private LocalDate endingDate;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="jobPosition_id")
	private JobPosition jobPosition;
	


}
