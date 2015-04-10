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
@Table(name = "experience")
public class Experience {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title", nullable = false, length = 128)
	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_start")
	private Date dateStart;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_end")
	private Date dateEnd;

	@Column(name = "current")
	private Boolean current;

	@Column(name = "description", nullable = true, length = 256)
	private String description;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@OneToOne
	@JoinColumn(name = "establishment_id")
	private Establishment establishment;

	public Experience() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Boolean getCurrent() {
		return current;
	}

	public void setCurrent(Boolean current) {
		this.current = current;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", title=" + title + ", dateStart="
				+ dateStart + ", dateEnd=" + dateEnd + ", current=" + current
				+ ", description=" + description + ", userId=" + userId
				+ ", establishment=" + establishment + "]";
	}

}
