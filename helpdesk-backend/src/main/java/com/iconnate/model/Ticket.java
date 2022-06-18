package com.iconnate.model;

import org.joda.time.DateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author samarpit
 *
 */
@ApiModel(description = "contains ticket related informations")
public class Ticket {

	@ApiModelProperty(notes = "Ticket ID")
	private int ticketId;
	@ApiModelProperty(notes = "HelpDesk ID")
	private int helpDeskId;
	@ApiModelProperty(notes = "Template ID")
	private int templateId;
	@ApiModelProperty(notes = "Ticket Description")
	private String ticketDescription;
	@ApiModelProperty(notes = "Attachment")
	private String attachment;
	@ApiModelProperty(notes = "Ticket Type")
	private String ticketType;
	@ApiModelProperty(notes = "Ticket Status")
	private String ticketStatus;
	@ApiModelProperty(notes = "assigned to")
	private String assignedTo;
	@ApiModelProperty(notes = "created by")
	private String createdBy;
	@ApiModelProperty(notes = "updated by")
	private String updatedBy;
	@ApiModelProperty(notes = "time stamp")
	private DateTime timeStamp; // check DataTime Type in DB and Java

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getHelpDeskId() {
		return helpDeskId;
	}

	public void setHelpDeskId(int helpDeskId) {
		this.helpDeskId = helpDeskId;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
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

	public DateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(DateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
