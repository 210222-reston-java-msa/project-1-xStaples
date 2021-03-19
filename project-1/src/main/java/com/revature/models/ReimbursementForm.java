package com.revature.models;

import java.time.LocalDateTime;

public class ReimbursementForm {

	private int id;
	private int amount;
	private LocalDateTime submitTime;
	private LocalDateTime resolveTime;
	private String description;
	private Object receipt;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
	
	public ReimbursementForm() {
		super();
	}

	public ReimbursementForm(int amount, String description, int authorId, int statusId, int typeId){
		this.amount = amount;
		this.description = description;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public ReimbursementForm(int id, int amount, LocalDateTime submitTime, LocalDateTime resolveTime, String description,
			Object receipt, int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitTime = submitTime;
		this.resolveTime = resolveTime;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public ReimbursementForm(int amount, LocalDateTime submitTime, LocalDateTime resolveTime, String description, Object receipt,
			int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.amount = amount;
		this.submitTime = submitTime;
		this.resolveTime = resolveTime;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDateTime getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(LocalDateTime submitTime) {
		this.submitTime = submitTime;
	}

	public LocalDateTime getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(LocalDateTime resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getReceipt() {
		return receipt;
	}

	public void setReceipt(Object receipt) {
		this.receipt = receipt;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [id=" + id + ", amount=" + amount + ", submitTime=" + submitTime + ", resolveTime="
				+ resolveTime + ", description=" + description + ", receipt=" + receipt + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + authorId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((resolveTime == null) ? 0 : resolveTime.hashCode());
		result = prime * result + resolverId;
		result = prime * result + statusId;
		result = prime * result + ((submitTime == null) ? 0 : submitTime.hashCode());
		result = prime * result + typeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementForm other = (ReimbursementForm) obj;
		if (amount != other.amount)
			return false;
		if (authorId != other.authorId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (resolveTime == null) {
			if (other.resolveTime != null)
				return false;
		} else if (!resolveTime.equals(other.resolveTime))
			return false;
		if (resolverId != other.resolverId)
			return false;
		if (statusId != other.statusId)
			return false;
		if (submitTime == null) {
			if (other.submitTime != null)
				return false;
		} else if (!submitTime.equals(other.submitTime))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	
	
}
