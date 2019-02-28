package kraken.pandora.orm;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 组织架构
 * 
 * @author zhying
 */
@Entity(name = "ac_org")
public class Org implements Comparable<Org> {

	public Org() {
		super();
	}

	public Org(int id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Org parent;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column
	private String name;

	@Column(name = "is_enabled")
	private Boolean enabled;

	@Column(name = "create_user_id")
	private int createUserId;

	@Column(name = "update_user_id")
	private int updateUserId;

	@Column(name = "create_time")

	private Timestamp createTime;

	@Column(name = "update_time")
	private Timestamp updateTime;

	@Column
	private String remark;

	@Column
	private String path;

	public boolean getIsRoot() {
		return this.getParent() == null;
	}

	@Override
	public int compareTo(Org target) {
		return Integer.compare(this.id, target.id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Org getParent() {
		return parent;
	}

	public void setParent(Org parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
