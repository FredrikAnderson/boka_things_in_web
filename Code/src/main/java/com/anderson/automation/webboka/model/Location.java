package com.anderson.automation.webboka.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String mainPosition;

    private String subPosition;
    
    private String heightPosition;
    
    private String comment;
    
    private Date changedDate;
    
    protected Location() {}


	public Long getId() {
		return id;
	}


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

	public String getMainPosition() {
		return mainPosition;
	}

	public void setMainPosition(String mainPosition) {
		this.mainPosition = mainPosition;
	}

	public String getSubPosition() {
		return subPosition;
	}

	public void setSubPosition(String subPosition) {
		this.subPosition = subPosition;
	}


	public String getHeightPosition() {
		return heightPosition;
	}


	public void setHeightPosition(String heightPosition) {
		this.heightPosition = heightPosition;
	}
	
    @Override
    public String toString() {
        return String.format("Location [id=%d]", id);
    }
}

