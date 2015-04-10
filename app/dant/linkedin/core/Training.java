package dant.linkedin.core;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "training")
public class Training {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 128)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_start", nullable = false)
	private Timestamp dateStart;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_end", nullable = false)
	private Timestamp dateEnd;
	

	@Column(name = "degree", nullable = false, length = 256)
	private String degree;

	@Column(name = "discipline", nullable = false, length = 256)
	private String discipline;
	
	@Column(name = "description", nullable = true, length = 256)
	private String description;
	
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	@Column(name = "establishment_id", nullable = false)
	private Integer establishmentId;
}
