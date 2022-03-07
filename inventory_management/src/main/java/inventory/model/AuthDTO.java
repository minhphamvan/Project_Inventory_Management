package inventory.model;

import java.util.Date;

public class AuthDTO implements java.io.Serializable {

	private int id;
	private MenuDTO menu;
	private RoleDTO role;
	private int permission;
	private int activeFlag;
	private Date createDate;
	private Date updateDate;

	public AuthDTO() {
	}

	public AuthDTO(MenuDTO menu, RoleDTO role, int permission, int activeFlag, Date createDate, Date updateDate) {
		this.menu = menu;
		this.role = role;
		this.permission = permission;
		this.activeFlag = activeFlag;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MenuDTO getMenu() {
		return this.menu;
	}

	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}

	public RoleDTO getRole() {
		return this.role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public int getPermission() {
		return this.permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public int getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
