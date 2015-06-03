package dant.linkedin.core;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	private Date dateStart;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_end", nullable = false)
	private Date dateEnd;
	

	@Column(name = "degree", nullable = false, length = 256)
	private String degree;

	@Column(name = "discipline", nullable = false, length = 256)
	private String discipline;
	
	@Column(name = "description", nullable = true, length = 256)
	private String description;
	
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	@OneToOne
  @JoinColumn(name = "establishment_id")
  private Establishment establishment;
	
	public Training()
  {
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Date getDateStart()
  {
    return dateStart;
  }

  public void setDateStart(Date dateStart)
  {
    this.dateStart = dateStart;
  }

  public Date getDateEnd()
  {
    return dateEnd;
  }

  public void setDateEnd(Date dateEnd)
  {
    this.dateEnd = dateEnd;
  }

  public String getDegree()
  {
    return degree;
  }

  public void setDegree(String degree)
  {
    this.degree = degree;
  }

  public String getDiscipline()
  {
    return discipline;
  }

  public void setDiscipline(String discipline)
  {
    this.discipline = discipline;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public Integer getUserId()
  {
    return userId;
  }

  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }

  public Establishment getEstablishment()
  {
    return establishment;
  }

  public void setEstablishment(Establishment establishment)
  {
    this.establishment = establishment;
  }

@Override
public String toString() {
	return "Training [id=" + id + ", name=" + name + ", dateStart=" + dateStart
			+ ", dateEnd=" + dateEnd + ", degree=" + degree + ", discipline="
			+ discipline + ", description=" + description + ", userId="
			+ userId + ", establishment=" + establishment + "]";
}

  


  
  
	
}
