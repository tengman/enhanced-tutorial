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
@TableName("t_class")
public class Class extends Model<Class> {

    private static final long serialVersionUID = 1L;

    /**
     * 逻辑主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 班级名称
     */
	private String name;


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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Class{" +
			"id=" + id +
			", name=" + name +
			"}";
	}
}
