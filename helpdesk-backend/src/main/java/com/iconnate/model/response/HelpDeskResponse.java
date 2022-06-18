package com.iconnate.model.response;

import java.sql.Date;

public class HelpDeskResponse {

	private long helpDeskId;
	private long companyId;
	private String name;
	private String description;
	private String logo;
	private String chatAvatar;
	private Date timeStamp;
	private String createdBy;
	private String updatedBy;
	private String deletedBy;
	private String message;

	public long getHelpDeskId() {
		return helpDeskId;
	}

	public void setHelpDeskId(long helpDeskId) {
		this.helpDeskId = helpDeskId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getChatAvatar() {
		return chatAvatar;
	}

	public void setChatAvatar(String chatAvatar) {
		this.chatAvatar = chatAvatar;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
}
