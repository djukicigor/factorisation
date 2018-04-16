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
	
	private Long companyId;
	
	private Long businessPartnerId;
	
	public InvoiceItemsDTO() {
		
	}
	
	public InvoiceItemsDTO(Long id, float amount, float unitPrice, float percentagePDV, float amountItems, Long goodsOrServicesId, Long companyId, Long businessPartnerId) {
		super();
		this.Id = id;
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.percentagePDV = percentagePDV;
		this.amountItems = amountItems;
		this.goodsOrservicesId = goodsOrServicesId;
		this.companyId = companyId;
		this.businessPartnerId = businessPartnerId;
	}

	@Override
	public String toString() {
		return "InvoiceItemsDTO [Id=" + Id + ", amount=" + amount + ", unitPrice=" + unitPrice + ", percentagePDV=" + percentagePDV + ", amountItems=" + amountItems + ", invoiceId=" + invoiceId + ", goodsOrservicesId="
				+ goodsOrservicesId + ", companyId=" + companyId + ", businessPartnerId=" + businessPartnerId + "]";
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
