package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceDTO {
	
	private Long Id;
	
	private String invoiceNumber;
	
	private Date invoiceDate;
	
	private Date valueDate;
	
	private float base;
	
	private float totalPDV;
	
	private float paymentAmount;
	
	private int invoiceStatus;
	
	private Long companyId;
	
	private Long businessYearId;
	
	private Long businessPartnerId;
	
	private List<Long> invoiceItemIds = new ArrayList<Long>();
	
	public InvoiceDTO() {
		
	}
	
	public InvoiceDTO(Long id, String invoiceNumber, Date invoiceDate, Date valueDate, int invoiceStatus, Long businessYearId) {
		super();
		Id = id;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.valueDate = valueDate;
		this.invoiceStatus = invoiceStatus;
		this.businessYearId = businessYearId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public float getTotalPDV() {
		return totalPDV;
	}

	public void setTotalPDV(float totalPDV) {
		this.totalPDV = totalPDV;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(int invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getBusinessYearId() {
		return businessYearId;
	}

	public void setBusinessYearId(Long businessYearId) {
		this.businessYearId = businessYearId;
	}

	public Long getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setBusinessPartnerId(Long businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public List<Long> getInvoiceItemIds() {
		return invoiceItemIds;
	}

	public void setInvoiceItemIds(List<Long> invoiceItemIds) {
		this.invoiceItemIds = invoiceItemIds;
	}
	
	

}
