package com.tete.tutorial.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
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
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    @TableId("course_title")
	private String courseTitle;
	private String type;
	private Float credits;
	private String speciality;


	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getCredits() {
		return credits;
	}

	public void setCredits(Float credits) {
		this.credits = credits;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	protected Serializable pkVal() {
		return this.courseTitle;
	}

	@Override
	public String toString() {
		return "Course{" +
			"courseTitle=" + courseTitle +
			", type=" + type +
			", credits=" + credits +
			", speciality=" + speciality +
			"}";
	}
}
