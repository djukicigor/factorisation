package dto;

public class BusinessYearDTO {
	
	private Long Id;
	
	private int year;
	
	private boolean closed;
	
	public BusinessYearDTO() {
		
	}
	
	public BusinessYearDTO(Long id, int year, boolean closed) {
		super();
		Id = id;
		this.year = year;
		this.closed = closed;
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
	
	

}
