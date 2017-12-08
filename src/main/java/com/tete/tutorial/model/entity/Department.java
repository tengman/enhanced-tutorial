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
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

	@TableId(value="dept_id", type= IdType.AUTO)
	private Integer deptId;
	@TableField("dept_name")
	private String deptName;


	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	protected Serializable pkVal() {
		return this.deptId;
	}

	@Override
	public String toString() {
		return "Department{" +
			"deptId=" + deptId +
			", deptName=" + deptName +
			"}";
	}
}
