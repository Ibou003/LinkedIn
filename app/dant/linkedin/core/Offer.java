package dant.linkedin.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "offer")
public class Offer {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "validate_date", nullable = false)
	private Date validateDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@Column(name = "nb_view", nullable = true)
	private Integer nbView;
	
	@Column(name = "title", nullable = false, length = 256)
	private String title;
	
	@Column(name = "company_id", nullable = true)
	private Integer companyId;
	
	@Column(name = "document_id", nullable = true)
	private Integer documentId;
	
//	@OneToOne
//	private Document document;
	
	public Offer() {
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", createDate=" + createDate
				+ ", validateDate=" + validateDate + ", endDate=" + endDate
				+ ", nbView=" + nbView + ", title=" + title + ", companyId="
				+ companyId + ", documentId=" + documentId + "]";
	}
	
}
