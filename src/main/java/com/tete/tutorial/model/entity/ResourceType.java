package com.tete.tutorial.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tengman
 * @since 2017-12-19
 */
@TableName("t_resource_type")
public class ResourceType extends Model<ResourceType> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 资源类型
     */
	private Integer type;
    /**
     * 资源描述
     */
	private String desc;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ResourceType{" +
			"id=" + id +
			", type=" + type +
			", desc=" + desc +
			"}";
	}
}
