package com.iconnate.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author samarpit
 *
 */
@ApiModel(description = "contains helpdesk details")
@Component
public class HelpDesk {

	@ApiModelProperty(notes = "helpdesk id which is a primary key and auto increemented value")
	private int helpDeskId;
	@ApiModelProperty(notes = "company id is a foreign key that will help to access company table data")
	private int companyId;
	@ApiModelProperty(notes = "helpdesk name")
	private String name;
	@ApiModelProperty(notes = "description about helpdesk")
	private String description;
	@ApiModelProperty(notes = "logo")
	private String logo;
	@ApiModelProperty(notes = "chat avatar")
	private String chatAvatar;
	@ApiModelProperty(notes = "time stamp")
	private Date timeStamp;
	@ApiModelProperty(notes = "helpdesk created by")
	private String createdBy;
	@ApiModelProperty(notes = "helpdesk updated by")
	private String updatedBy;
	@ApiModelProperty(notes = "helpdesk deleted by")
	private String deletedBy;
	@ApiModelProperty(notes = "helpdesk delete status")
	private boolean isActive = true;

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public long getHelpDeskId() {
		return helpDeskId;
	}

	public void setHelpDeskId(int helpDeskId) {
		this.helpDeskId = helpDeskId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
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
