package bysj.zxpc.bean;

	public class MenuBean {
	  String treeId;
	  String treeType;
	  String treeRole;
	  String treeUrl;
	  String treeName;
	public MenuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuBean(String treeId, String treeType, String treeRole, String treeUrl, String treeName) {
		super();
		this.treeId = treeId;
		this.treeType = treeType;
		this.treeRole = treeRole;
		this.treeUrl = treeUrl;
		this.treeName = treeName;
	}
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	public String getTreeType() {
		return treeType;
	}
	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}
	public String getTreeRole() {
		return treeRole;
	}
	public void setTreeRole(String treeRole) {
		this.treeRole = treeRole;
	}
	public String getTreeUrl() {
		return treeUrl;
	}
	public void setTreeUrl(String treeUrl) {
		this.treeUrl = treeUrl;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
  
  
}
