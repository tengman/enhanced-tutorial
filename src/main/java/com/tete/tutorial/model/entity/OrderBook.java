package com.tete.tutorial.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tengman
 * @since 2017-12-05
 */
@TableName("order_book")
public class OrderBook extends Model<OrderBook> {

    private static final long serialVersionUID = 1L;

    @TableId("staff_id")
	private String staffId;
	@TableField("sec_id")
	private Integer secId;
	@TableField("book_title")
	private String bookTitle;
	private String isbn;
	private String remark;
	private Integer approval;


	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Integer getSecId() {
		return secId;
	}

	public void setSecId(Integer secId) {
		this.secId = secId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getApproval() {
		return approval;
	}

	public void setApproval(Integer approval) {
		this.approval = approval;
	}

	@Override
	protected Serializable pkVal() {
		return this.staffId;
	}

	@Override
	public String toString() {
		return "OrderBook{" +
			"staffId=" + staffId +
			", secId=" + secId +
			", bookTitle=" + bookTitle +
			", isbn=" + isbn +
			", remark=" + remark +
			", approval=" + approval +
			"}";
	}
}
