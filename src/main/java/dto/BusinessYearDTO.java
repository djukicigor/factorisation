package dto;

public class BusinessYearDTO {
	
	private Long Id;
	
	private int year;
	
	private boolean closed;
	
	private Long invoiceId;
	
	public BusinessYearDTO() {
		
	}
	
	public BusinessYearDTO(Long id, int year, boolean closed, Long invoiceId) {
		super();
		Id = id;
		this.year = year;
		this.closed = closed;
		this.invoiceId = invoiceId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean getClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	
	

}
