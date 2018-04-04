package dto;

public class CityDTO {
	
	private Long Id;
	
	private String name;
	
	private String postalCode;
	
	private Long companyId;
	
	private Long businessPartnerId;
	
	public CityDTO() {}
	
	public CityDTO(Long id, String name, String postalCode, Long companyId, Long businessPartnerId) {
		super();
		Id = id;
		this.name = name;
		this.postalCode = postalCode;
		this.companyId = companyId;
		this.businessPartnerId = businessPartnerId;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setBusinessPartnerId(Long businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}
	
	

}
	
	
