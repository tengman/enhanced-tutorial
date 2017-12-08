package com.tete.tutorial.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
@TableName("t_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 逻辑主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 角色标识字符串
     */
	private String role;
    /**
     * 角色描述
     */
	private String desc;
    /**
     * 资源集合，逗号分隔
     */
	private String resourceIds;
    /**
     * 角色状态:1-可用 -1不可用
     */
	private Integer state;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Role{" +
			"id=" + id +
			", role=" + role +
			", desc=" + desc +
			", resourceIds=" + resourceIds +
			", state=" + state +
			"}";
	}
}
