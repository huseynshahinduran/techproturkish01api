package techproedturkish01.techproedturkish01api;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Booking {

	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("totalprice")
	private Integer totalprice;
	@JsonProperty("depositpaid")
	private Boolean depositpaid;
	@JsonProperty("bookingdates")
	private BookingDates bookingdates;
	@JsonProperty("additionalneeds")
	private String additionalneeds;

	@JsonProperty("firstname")
	public String getFirstname() {
	return firstname;
	}

	@JsonProperty("firstname")
	public void setFirstname(String firstname) {
	this.firstname = firstname;
	}

	@JsonProperty("lastname")
	public String getLastname() {
	return lastname;
	}

	@JsonProperty("lastname")
	public void setLastname(String lastname) {
	this.lastname = lastname;
	}

	@JsonProperty("totalprice")
	public Integer getTotalprice() {
	return totalprice;
	}

	@JsonProperty("totalprice")
	public void setTotalprice(Integer totalprice) {
	this.totalprice = totalprice;
	}

	@JsonProperty("depositpaid")
	public Boolean getDepositpaid() {
	return depositpaid;
	}

	@JsonProperty("depositpaid")
	public void setDepositpaid(Boolean depositpaid) {
	this.depositpaid = depositpaid;
	}

	@JsonProperty("bookingdates")
	public BookingDates getBookingdates() {
	return bookingdates;
	}

	@JsonProperty("bookingdates")
	public void setBookingdates(BookingDates bookingdates) {
	this.bookingdates = bookingdates;
	}

	@JsonProperty("additionalneeds")
	public String getAdditionalneeds() {
	return additionalneeds;
	}

	@JsonProperty("additionalneeds")
	public void setAdditionalneeds(String additionalneeds) {
	this.additionalneeds = additionalneeds;
	}

	public Booking(String firstname, String lastname, Integer totalprice, Boolean depositpaid,
			BookingDates bookingdates, String additionalneeds) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}

	public Booking() {
		
	}

	@Override
	public String toString() {
		return "Booking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
				+ ", depositpaid=" + depositpaid + ", bookingdates=" + bookingdates + ", additionalneeds="
				+ additionalneeds + "]";
	}
	
}
