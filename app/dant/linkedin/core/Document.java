package dant.linkedin.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false, length = 128)
	private String name;

	@Column(name = "path", length = 256)
	private String path;

	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", length = 256)
	private DocumentType documentType;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "company_id")
	private Integer companyId;

	public Document() {
	}

	
	public Document(String name, String path, DocumentType documentType) {
		super();
		this.name = name;
		this.path = path;
		this.documentType = documentType;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}


  @Override
  public String toString()
  {
    return "Document [name=" + name + ", documentType=" + documentType + "]";
  }
	
}
