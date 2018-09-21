package com.anderson.automation.webboka.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    
    private Date bookFrom;

    private Date bookTo;
    
    private Date changedDate;
    
    
    protected Booking() {}    

    @Override
    public String toString() {
        return String.format("Item [id=%d]", id);
    }

	public Long getId() {
		return id;
	}

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

	public Date getBookFrom() {
		return bookFrom;
	}

	public void setBookFrom(Date bookFrom) {
		this.bookFrom = bookFrom;
	}

	public Date getBookTo() {
		return bookTo;
	}

	public void setBookTo(Date bookTo) {
		this.bookTo = bookTo;
	}
}

