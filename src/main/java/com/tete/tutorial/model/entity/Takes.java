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
public class Takes extends Model<Takes> {

    private static final long serialVersionUID = 1L;

    @TableId("student_id")
	private String studentId;
	@TableField("sec_id")
	private String secId;
	private Float score;


	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	protected Serializable pkVal() {
		return this.studentId;
	}

	@Override
	public String toString() {
		return "Takes{" +
			"studentId=" + studentId +
			", secId=" + secId +
			", score=" + score +
			"}";
	}
}
