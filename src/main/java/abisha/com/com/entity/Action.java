package abisha.com.com.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "actions")
public class Action {
	@Id
    private String id;

    private String recordId;
    private String actionBy; // admin/user
    private String comment;
    private String actionStatus;

    private LocalDateTime actionDate;

    public Action() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}

	public LocalDateTime getActionDate() {
		return actionDate;
	}

	public void setActionDate(LocalDateTime actionDate) {
		this.actionDate = actionDate;
	}
    
    
}
