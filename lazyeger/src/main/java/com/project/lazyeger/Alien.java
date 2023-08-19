package com.project.lazyeger;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="alien_table")
public class Alien {
	
	@Id
	private int aid;
	private String aname;
	
	@OneToMany(mappedBy = "alien", fetch = FetchType.EAGER)
	private List<Laptop> laptops = new ArrayList<Laptop>();
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}
	
}
