package entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Guest {
	
	private String name;
	private LocalDate date;
	private Country country;
	private Language language;
	private Hobby hobby;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Hobby getHobby() {
		return hobby;
	}
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	
	 public int getAge() {
	        LocalDate currentDate = LocalDate.now();
	        return Period.between(date, currentDate).getYears();
	    }

	public Guest(String name, LocalDate date, Country country, Language language, Hobby hobby) {
		super();
		this.name = name;
		this.date = date;
		this.country = country;
		this.language = language;
		this.hobby = hobby;
	}
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Guest [name=" + name + ", date=" + date + ", country=" + country + ", language=" + language + ", hobby="
				+ hobby + "]";
	}
	
	

}
