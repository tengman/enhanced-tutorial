package com.tete.tutorial.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tengman
 * @since 2017-12-05
 */
public class Class extends Model<Class> {

    private static final long serialVersionUID = 1L;

    @TableId("class_id")
	private String classId;
	@TableField("class_name")
	private String className;
	private String year;
	@TableField("spec_name")
	private String specName;


	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	@Override
	protected Serializable pkVal() {
		return this.classId;
	}

	@Override
	public String toString() {
		return "Class{" +
			"classId=" + classId +
			", className=" + className +
			", year=" + year +
			", specName=" + specName +
			"}";
	}
}
