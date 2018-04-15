package dto;

public class BusinessPartnerDTO {
	
	private Long Id;
	
	private String name;
	
	private String address;
	
	private String pib;
	
	private String type;
	
	private Long companyId;
	
	private Long cityId;
	
	private Long invoiceId;
	
	
	public BusinessPartnerDTO() {
		
	}
	
	public BusinessPartnerDTO(Long id, String name, String address, String pib, String type, Long companyId, Long cityId, Long invoiceId) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.pib = pib;
		this.type = type;
		this.companyId = companyId;
		this.cityId = cityId;
		this.invoiceId = invoiceId;
		
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}
	
	
	


}
