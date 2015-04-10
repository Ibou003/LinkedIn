package dant.linkedin.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 128)
	private String name;
	
	@Column(name = "description", nullable = true, length = 256)
	private String description;
	
	@Column(name = "user_id", nullable = false)
	private Integer userId;
}
