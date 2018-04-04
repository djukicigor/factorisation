package dto;

public class CompanyDTO {
	
	private Long Id;
	
	private String name;
	
	private String address;
	
	private String pib;
	
	private String number;
	
	private String email;
	
	private String logo;
	
	private Long cityId;
	
	private Long pricelistId;
	
	private Long businessPartnersId;
	
	public CompanyDTO() {
		
	}
	
	public CompanyDTO(Long id, String name, String address, String pib, String number, String email, String logo, Long cityId, Long pricelistId, Long businessPartnersId) {
		Id = id;
		this.name = name;
		this.address = address;
		this.pib = pib;
		this.number = number;
		this.email = email;
		this.logo = logo;
		this.cityId = cityId;
		this.pricelistId = pricelistId;
		this.businessPartnersId = businessPartnersId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getPricelistId() {
		return pricelistId;
	}

	public void setPricelistId(Long pricelistId) {
		this.pricelistId = pricelistId;
	}

	public Long getBusinessPartnersId() {
		return businessPartnersId;
	}

	public void setBusinessPartnersId(Long businessPartnersId) {
		this.businessPartnersId = businessPartnersId;
	}
	
	
	
	

}
