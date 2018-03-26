package dto;

public class CityDTO {
	
	private Long Id;
	
	private String name;
	
	private String postalCode;
	
	private Long companyId;
	
	public CityDTO() {}
	
	public CityDTO(Long id, String name, String postalCode, Long companyId) {
		super();
		Id = id;
		this.name = name;
		this.postalCode = postalCode;
		this.companyId = companyId;
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
	
	

}
	
	
