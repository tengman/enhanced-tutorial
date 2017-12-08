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
public class Section extends Model<Section> {

    private static final long serialVersionUID = 1L;

	@TableId(value="sec_id", type= IdType.AUTO)
	private Integer secId;
	@TableField("course_title")
	private String courseTitle;
	private String year;
	private Integer limitCount;
	@TableField("staff_id")
	private String staffId;


	public Integer getSecId() {
		return secId;
	}

	public void setSecId(Integer secId) {
		this.secId = secId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getLimitCount() {
		return limitCount;
	}

	public void setLimitCount(Integer limitCount) {
		this.limitCount = limitCount;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@Override
	protected Serializable pkVal() {
		return this.secId;
	}

	@Override
	public String toString() {
		return "Section{" +
			"secId=" + secId +
			", courseTitle=" + courseTitle +
			", year=" + year +
			", limitCount=" + limitCount +
			", staffId=" + staffId +
			"}";
	}
}
