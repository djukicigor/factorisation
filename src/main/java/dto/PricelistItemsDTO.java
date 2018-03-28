package dto;

public class PricelistItemsDTO {
	
	private Long Id;
	
	private Float price;
	
	private Long pricelistId;
	
	private Long goodsOrServicesId;
	
	public PricelistItemsDTO() {
		
	}
	
	public PricelistItemsDTO(Long id, Float price, Long pricelistId, Long goodsOrServicesId) {
		super();
		Id = id;
		this.price = price;
		this.pricelistId = pricelistId;
		this.goodsOrServicesId = goodsOrServicesId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getPricelistId() {
		return pricelistId;
	}

	public void setPricelistId(Long pricelistId) {
		this.pricelistId = pricelistId;
	}

	public Long getGoodsOrServicesId() {
		return goodsOrServicesId;
	}

	public void setGoodsOrServicesId(Long goodsOrServicesId) {
		this.goodsOrServicesId = goodsOrServicesId;
	}
	
	

}
