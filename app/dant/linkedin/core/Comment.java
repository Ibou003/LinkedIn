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
@Table(name = "comment")
public class Comment {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	private Date createDate;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "post_id", nullable = true)
	private Integer postId;

	@Column(name = "offer_id", nullable = true)
	private Integer offerId;
	
	public Comment() {
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", createDate=" + createDate
				+ ", content=" + content + ", userId=" + userId + ", postId="
				+ postId + ", offerId=" + offerId + "]";
	}
	
	
}
