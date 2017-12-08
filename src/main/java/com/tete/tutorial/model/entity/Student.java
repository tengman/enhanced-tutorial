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
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @TableId("student_id")
	private String studentId;
	@TableField("student_name")
	private String studentName;
	@TableField("id_card")
	private String idCard;
	private String year;
	@TableField("class_id")
	private String classId;
	@TableField("telephone_number")
	private String telephoneNumber;
	@TableField("student_origin_base")
	private String studentOriginBase;
	private String gender;
	@TableField("pic_path")
	private String picPath;
	@TableField("leave_of_absence")
	private Integer leaveOfAbsence;
	@TableField("leave_school")
	private Integer leaveSchool;


	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getStudentOriginBase() {
		return studentOriginBase;
	}

	public void setStudentOriginBase(String studentOriginBase) {
		this.studentOriginBase = studentOriginBase;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Integer getLeaveOfAbsence() {
		return leaveOfAbsence;
	}

	public void setLeaveOfAbsence(Integer leaveOfAbsence) {
		this.leaveOfAbsence = leaveOfAbsence;
	}

	public Integer getLeaveSchool() {
		return leaveSchool;
	}

	public void setLeaveSchool(Integer leaveSchool) {
		this.leaveSchool = leaveSchool;
	}

	@Override
	protected Serializable pkVal() {
		return this.studentId;
	}

	@Override
	public String toString() {
		return "Student{" +
			"studentId=" + studentId +
			", studentName=" + studentName +
			", idCard=" + idCard +
			", year=" + year +
			", classId=" + classId +
			", telephoneNumber=" + telephoneNumber +
			", studentOriginBase=" + studentOriginBase +
			", gender=" + gender +
			", picPath=" + picPath +
			", leaveOfAbsence=" + leaveOfAbsence +
			", leaveSchool=" + leaveSchool +
			"}";
	}
}
