package com.app.skp.response;

import org.springframework.stereotype.Component;

@Component
public class DashboardResponse {

	private Long plansCount;
	private Long citizensApCnt;//citizens approved 
	private Long citizenssDnCnt;//citizens denied
	private Double benefitAmtTotal;
	public Long getPlansCount() {
		return plansCount;
	}
	public void setPlansCount(Long plansCount) {
		this.plansCount = plansCount;
	}
	public Long getCitizensApCnt() {
		return citizensApCnt;
	}
	public void setCitizensApCnt(Long citizensApCnt) {
		this.citizensApCnt = citizensApCnt;
	}
	public Long getCitizenssDnCnt() {
		return citizenssDnCnt;
	}
	public void setCitizenssDnCnt(Long citizenssDnCnt) {
		this.citizenssDnCnt = citizenssDnCnt;
	}
	public Double getBenefitAmtTotal() {
		return benefitAmtTotal;
	}
	public void setBenefitAmtTotal(Double benefitAmtTotal) {
		this.benefitAmtTotal = benefitAmtTotal;
	}
	public DashboardResponse() {
		super();
	}
	@Override
	public String toString() {
		return "DashboardResponse [plansCount=" + plansCount + ", citizensApCnt=" + citizensApCnt + ", citizenssDnCnt="
				+ citizenssDnCnt + ", benefitAmtTotal=" + benefitAmtTotal + "]";
	}
	
	
}
