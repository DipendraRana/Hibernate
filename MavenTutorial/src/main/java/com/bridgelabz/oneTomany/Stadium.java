package com.bridgelabz.oneTomany;

import java.util.HashSet;
import java.util.Set;

public class Stadium {
	
	private int id;
	private String name;
	private int capacity;
	private String country;
	private Set<CricketMatch> matches=new HashSet<CricketMatch>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity=capacity;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country=country;
	}
	public Set<CricketMatch> getMatches(){
		return matches;
	}
	public void setMatches(Set<CricketMatch> matches) {
		this.matches=matches;
	}
	@Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", country=" + country
                + ", capacity=" + capacity + "]";
    }                

}
