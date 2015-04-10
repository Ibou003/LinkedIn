package dant.linkedin.core;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	private Date createDate;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	@Column(name = "document_id", nullable = true)
	private Integer documentId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id")
	private List<Comment> comments;

	public Post() {
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getDocumentId() {
		return documentId;
	}


	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", createDate=" + createDate + ", content="
				+ content + ", userId=" + userId + ", documentId=" + documentId
				+ ", comments=" + comments + "]";
	}

	
	
	
}
