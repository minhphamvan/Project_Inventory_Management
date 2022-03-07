package inventory.model;

import java.util.Date;

public class UserRoleDTO implements java.io.Serializable {

	private int id;
	private RoleDTO role;
	private UserDTO user;
	private int activeFlag;
	private Date createDate;
	private Date updateDate;

	public UserRoleDTO() {
	}

	public UserRoleDTO(RoleDTO role, UserDTO user, int activeFlag, Date createDate, Date updateDate) {
		this.role = role;
		this.user = user;
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

	public RoleDTO getRole() {
		return this.role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public UserDTO getUser() {
		return this.user;
	}

	public void setUsers(UserDTO user) {
		this.user = user;
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
