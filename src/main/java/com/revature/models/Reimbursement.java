package com.revature.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="reimbursements")
public class Reimbursement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="reim_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimId;
	
	private double amount;
	private String status;
	
	@Column(name="result_of", nullable=true)
	private String result;
	
	@Column(name="submit_by")
	private int submitById;
	
	@Column(name="resolved_by", nullable=true)
	private int resolvedById;
	
	@Column(name="submit_date")
	private String submitDate;
	
	@Column(name="resolved_date", nullable=true)
	private String resolvedDate;
	
	private String description;
	
	@Column(nullable=true)
	private String reason;
	
	@Column(nullable=true)
	private String receipt;

	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int reimId) {
		super();
		this.reimId = reimId;
	}

	public Reimbursement(int reimId, double amount, String status, String result, int submitById, int resolvedById,
			String submitDate, String resolvedDate, String description, String reason, String receipt) {
		super();
		this.reimId = reimId;
		this.amount = amount;
		this.status = status;
		this.result = result;
		this.submitById = submitById;
		this.resolvedById = resolvedById;
		this.submitDate = submitDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.reason = reason;
		this.receipt = receipt;
	}

	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getSubmitById() {
		return submitById;
	}

	public void setSubmitById(int submitById) {
		this.submitById = submitById;
	}

	public int getResolvedById() {
		return resolvedById;
	}

	public void setResolvedById(int resolvedById) {
		this.resolvedById = resolvedById;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + reimId;
		result = prime * result + resolvedById;
		result = prime * result + ((resolvedDate == null) ? 0 : resolvedDate.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + submitById;
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (reimId != other.reimId)
			return false;
		if (resolvedById != other.resolvedById)
			return false;
		if (resolvedDate == null) {
			if (other.resolvedDate != null)
				return false;
		} else if (!resolvedDate.equals(other.resolvedDate))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitById != other.submitById)
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", amount=" + amount + ", status=" + status + ", result=" + result
				+ ", submitById=" + submitById + ", resolvedById=" + resolvedById + ", submitDate=" + submitDate
				+ ", resolvedDate=" + resolvedDate + ", description=" + description + ", reason=" + reason
				+ ", receipt=" + receipt + "]";
	}
	
}
