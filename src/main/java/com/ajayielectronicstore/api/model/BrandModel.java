package com.ajayielectronicstore.api.model;

import java.util.Date;

public class BrandModel {

	private String name;
	private Date creationDate;
	private Boolean enabled;
    private Integer adminId;

    public BrandModel() {
    	
    }

	/**
	 * @param name
	 * @param creationDate
	 * @param enabled
	 * @param adminId
	 */
	public BrandModel(String name, Date creationDate, Boolean enabled, Integer adminId) {
		this.name = name;
		this.creationDate = creationDate;
		this.enabled = enabled;
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public boolean isInValidState() {
		Integer result = 1;
		
		result *= ((adminId == null) ? 0 : 1);
		result *= ((creationDate == null) ? 0 : 1);
		result *= ((enabled == null) ? 0 : 1);
		result *= ((name == null) ? 0 : 1);
		
		return result > 0;
	}

	@Override
	public String toString() {
		return "BrandModel [name=" + name + ", creationDate=" + creationDate + ", enabled=" + enabled + ", adminId="
				+ adminId + "]";
	}	
	
}
