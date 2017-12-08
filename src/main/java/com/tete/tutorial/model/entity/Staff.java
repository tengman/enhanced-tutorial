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
public class Staff extends Model<Staff> {

    private static final long serialVersionUID = 1L;

    @TableId("staff_id")
	private String staffId;
	@TableField("staff_name")
	private String staffName;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

	@Override
	public String toString() {
		return "Staff{" +
			"staffId=" + staffId +
			", staffName=" + staffName +
			"}";
	}
}
