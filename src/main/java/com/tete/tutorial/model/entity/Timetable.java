package com.tete.tutorial.model.entity;

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
public class Timetable extends Model<Timetable> {

    private static final long serialVersionUID = 1L;

	@TableField("sec_id")
	private Integer secId;
	private String time;
	private String weeks;
	private String week;
	private String classroom;


	public Integer getSecId() {
		return secId;
	}

	public void setSecId(Integer secId) {
		this.secId = secId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	@Override
	protected Serializable pkVal() {
		return this.secId;
	}

	@Override
	public String toString() {
		return "Timetable{" +
			"secId=" + secId +
			", time=" + time +
			", weeks=" + weeks +
			", week=" + week +
			", classroom=" + classroom +
			"}";
	}
}
