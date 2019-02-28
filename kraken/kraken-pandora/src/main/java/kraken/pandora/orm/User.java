package kraken.pandora.orm;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * 系统用户
 *
 * @author zhying
 */
@Entity(name = "ac_user")
public class User {

	/**
	 *
	 */
	public User() {
		super();
	}

	/**
	 * @param id
	 */
	public User(int id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column(name = "login_name")
	private String loginName;

	@Column(name = "job_number")
	private String jobNumber;

	@Column(name = "login_password")
	private String loginPassword;

	@Column(name = "is_enabled")
	private Boolean enabled;

	@Column(name = "last_login_time")
	private Timestamp lastLoginTime;

	@Column(name = "invalid_login_count")
	private int invalidLoginCount;

	@Column(name = "link_tel")
	private String linkTel;

	@Column(name = "link_phone")
	private String linkPhone;

	@Column
	private String remark;

	@Column(name = "create_user_id")
	private int createUserId;

	@Column(name = "update_user_id")
	private int updateUserId;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "update_time")
	private Timestamp updateTime;

	@Column(name = "customer_id")
	private Integer customerId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "org_id", nullable = false)
	private Org org;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getInvalidLoginCount() {
		return invalidLoginCount;
	}

	public void setInvalidLoginCount(int invalidLoginCount) {
		this.invalidLoginCount = invalidLoginCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public int getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Override
	public String toString() {
		return "[id=" + this.id + ",loginName=" + this.loginName + ",name=" + this.name + ",enabled=" + this.enabled + "]";
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
