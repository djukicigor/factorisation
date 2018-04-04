package dto;

public class GoodsOrServicesDTO {

	private Long Id;
	
	private String name;
	
	private String unit;
	
	private Long groupOfGoodsId;
	
	private Long pricelistItemsId;
	
	private Long invoiceItemsId;
	
	public GoodsOrServicesDTO() {
		
	}
	
	public GoodsOrServicesDTO(Long id, String name, String unit, Long groupOfGoodsId, Long pricelistItemsId, Long invoiceItemsId) {
		super();
		Id = id;
		this.name = name;
		this.unit = unit;
		this.groupOfGoodsId = groupOfGoodsId;
		this.pricelistItemsId = pricelistItemsId;
		this.invoiceItemsId = invoiceItemsId;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getGroupOfGoodsId() {
		return groupOfGoodsId;
	}

	public void setGroupOfGoodsId(Long groupOfGoodsId) {
		this.groupOfGoodsId = groupOfGoodsId;
	}

	public Long getPricelistItemsId() {
		return pricelistItemsId;
	}

	public void setPricelistItemsId(Long pricelistItemsId) {
		this.pricelistItemsId = pricelistItemsId;
	}

	public Long getInvoiceItemsId() {
		return invoiceItemsId;
	}

	public void setInvoiceItemsId(Long invoiceItemsId) {
		this.invoiceItemsId = invoiceItemsId;
	}
	
	
}
