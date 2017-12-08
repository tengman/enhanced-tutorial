package com.tete.tutorial.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
public class Speciality extends Model<Speciality> {

    private static final long serialVersionUID = 1L;

	@TableId(value="spec_id", type= IdType.AUTO)
	private Integer specId;
	@TableField("dept_name")
	private String deptName;
	@TableField("spec_name")
	private String specName;
	private String year;


	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	protected Serializable pkVal() {
		return this.specId;
	}

	@Override
	public String toString() {
		return "Speciality{" +
			"specId=" + specId +
			", deptName=" + deptName +
			", specName=" + specName +
			", year=" + year +
			"}";
	}
}
