package dto;

public class GroupOfGoodsDTO {
	
	private Long Id;
	
	private String name;
	
	private Float percentage;
	
	private Long goodsOrServicesId;
	
	public GroupOfGoodsDTO() {
		
	}
	
	public GroupOfGoodsDTO(Long id, String name, Float percentage, Long goodsOrServicesId) {
		super();
		Id = id;
		this.name = name;
		this.percentage = percentage;
		this.goodsOrServicesId = goodsOrServicesId;
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

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public Long getGoodsOrServicesId() {
		return goodsOrServicesId;
	}

	public void setGoodsOrServicesId(Long goodsOrServicesId) {
		this.goodsOrServicesId = goodsOrServicesId;
	}

	
	
	

}
