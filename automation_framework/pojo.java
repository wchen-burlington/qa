package automation_framework;

public class pojo {
	
	public String orgName;
	public String orgType;
	public String parentOrgName;
	public String parentOrgType;
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getParentOrgName() {
		return parentOrgName;
	}
	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}
	public String getParentOrgType() {
		return parentOrgType;
	}
	public void setParentOrgType(String parentOrgType) {
		this.parentOrgType = parentOrgType;
	}
	
	@Override
	public String toString(){
		return parentOrgName + "/" + orgName;
	}
	
}
