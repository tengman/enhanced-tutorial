package com.tete.tutorial.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
@TableName("t_resource")
public class Resource extends Model<Resource> {

    private static final long serialVersionUID = 1L;

    /**
     * 逻辑主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 名称
     */
	private String name;
    /**
     * 资源所属类型
     */
	private Integer type;
    /**
     * 资源的url
     */
	private String url;
    /**
     * 父类Id
     */
	private Integer parentId;
    /**
     * 资源是否可用 1可用，-1不可用
     */
	private Integer state;
	/**
	 * 增删改查
	 */
	private Integer operation;
	
	@TableField(exist=false)
	private List<Resource> resources = new ArrayList<>();


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getOperation() {
		return operation;
	}

	public void setOperation(Integer operation) {
		this.operation = operation;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(Resource resource) {
		this.resources.add(resource);
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Resource{" +
			"id=" + id +
			", name=" + name +
			", type=" + type +
			", url=" + url +
			", parentId=" + parentId +
			", state=" + state +
			"}";
	}
}
