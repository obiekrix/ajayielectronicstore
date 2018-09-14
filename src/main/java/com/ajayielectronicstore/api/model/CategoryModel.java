package com.ajayielectronicstore.api.model;

import java.util.Date;

public class CategoryModel {
	
	private String name;
	private String description;
	private Date creationDate;
	private Boolean enabled;
    private Integer adminId;
    
    public CategoryModel() {
    	
    }
    
	/**
	 * @param name
	 * @param description
	 * @param creationDate
	 * @param enabled
	 * @param adminId
	 */
	public CategoryModel(String name, String description, Date creationDate, Boolean enabled, Integer adminId) {
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.enabled = enabled;
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public boolean isInValidState() {
		Integer result = 1;
		
		result *= ((adminId == null) ? 0 : 1);
		result *= ((creationDate == null) ? 0 : 1);
		result *= ((enabled == null) ? 0 : 1);
		result *= ((name == null) ? 0 : 1);
		result *= ((description == null) ? 0 : 1);
		
		return result > 0;
	}
	
	@Override
	public String toString() {
		return "CategoryModel [name=" + name + ", description=" + description + ", creationDate=" + creationDate
				+ ", enabled=" + enabled + ", adminId=" + adminId + "]";
	}    
    
}
