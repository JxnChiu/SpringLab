package com.jason.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Table_User")
@JsonInclude(Include.NON_NULL)
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1431266055238341730L;

	public UserEntity() {
	};

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg" )
//	@SequenceGenerator(name="sg", sequenceName="t_user_id_seq", allocationSize = 1)
	@Column(name = "user_oid", unique = true, nullable = false, updatable = false)
	private Long oid;

	// 最短最長可以限制嗎？
	@Column(name = "account", length = 32, updatable = false, nullable = false)
	private String account;

	// 最短最長可以限制嗎？
	@Column(name = "mema", length = 32, nullable = false)
	private String mema;

	// email 可以驗證嗎？
	@Email(message = "Email should be valid")
	@Column(name = "email", length = 64, nullable = false)
	private String email;

	// 預設值不會用???????????
//	@Column(name = "is_delete", columnDefinition = "boolean default true")
	@Column(name = "is_delete")
	private Boolean isDelete = false;

//	@Column(name = "type", columnDefinition = "integer default 25")
	@Column(name = "type")
	private Integer type = 25;

	// 當下時間要怎麼抓
	@Column(name = "create_time", updatable = false)
	private Timestamp createTime;

	@Column(name = "update_time")
	private Timestamp updateTime;

	// 當下時間的抓法這樣對嗎？
	@PrePersist
	private void onCreate() {
		this.createTime = new Timestamp(System.currentTimeMillis());
	}

	@PreUpdate
	private void onUpdate() {
		this.updateTime = new Timestamp(System.currentTimeMillis());
	}

	// ================================================================

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getMema() {
		return mema;
	}

	public void setMema(String mema) {
		this.mema = mema;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
