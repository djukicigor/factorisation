package dto;

public class InvoiceItemsDTO {
	
	private Long Id;
	
	private float amount;
	
	private float unitPrice;
	
	private float rebate;
	
	private float basePDV;
	
	private float percentagePDV;
	
	private float amountPDV;
	
	private float amountItems;
	
	private Long invoiceId;
	
	private Long goodsOrservicesId;
	
	public InvoiceItemsDTO() {
		
	}
	
	public InvoiceItemsDTO(Long id, float amount, float unitPrice, float rebate, float basePDV, float percentagePDV, float amountPDV, float amountItems, Long invoiceId, Long goodsOrServicesId) {
		super();
		Id = id;
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.rebate = rebate;
		this.basePDV = basePDV;
		this.percentagePDV = percentagePDV;
		this.amountPDV = amountPDV;
		this.amountItems = amountItems;
		this.invoiceId = invoiceId;
		this.goodsOrservicesId = goodsOrServicesId;
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public float getRebate() {
		return rebate;
	}

	public void setRebate(float rebate) {
		this.rebate = rebate;
	}

	public float getBasePDV() {
		return basePDV;
	}

	public void setBasePDV(float basePDV) {
		this.basePDV = basePDV;
	}

	public float getPercentagePDV() {
		return percentagePDV;
	}

	public void setPercentagePDV(float percentagePDV) {
		this.percentagePDV = percentagePDV;
	}

	public float getAmountPDV() {
		return amountPDV;
	}

	public void setAmountPDV(float amountPDV) {
		this.amountPDV = amountPDV;
	}

	public float getAmountItems() {
		return amountItems;
	}

	public void setAmountItems(float amountItems) {
		this.amountItems = amountItems;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getGoodsOrservicesId() {
		return goodsOrservicesId;
	}

	public void setGoodsOrservicesId(Long goodsOrservicesId) {
		this.goodsOrservicesId = goodsOrservicesId;
	}
	
	

}
