package edu.idat.pe.model;

import java.util.Objects;

public class Orden {
	private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
	
    public Orden() {
		super();
	}

	public Orden(double price, String currency, String method, String intent, String description) {
		super();
		this.price = price;
		this.currency = currency;
		this.method = method;
		this.intent = intent;
		this.description = description;
	}

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getIntent() {
		return intent;
	}


	public void setIntent(String intent) {
		this.intent = intent;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency, description, intent, method, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orden other = (Orden) obj;
		return Objects.equals(currency, other.currency) && Objects.equals(description, other.description)
				&& Objects.equals(intent, other.intent) && Objects.equals(method, other.method)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	@Override
	public String toString() {
		return "Orden [price=" + price + ", currency=" + currency + ", method=" + method + ", intent=" + intent
				+ ", description=" + description + "]";
	}
  
}
