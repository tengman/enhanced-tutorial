package com.tete.tutorial.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
@TableName("t_book")
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    /**
     * 逻辑主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 书名
     */
	private String title;
    /**
     * 出版社
     */
	private String press;
    /**
     * 书籍所属类别
     */
	private Integer category;
    /**
     * 作者
     */
	private String author;
    /**
     * 印刷日期
     */
	private Date printingPeriod;
    /**
     * 编号
     */
	private String no;
    /**
     * 单价
     */
	private BigDecimal price;
    /**
     * 记录创建时间
     */
	private Date createTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPrintingPeriod() {
		return printingPeriod;
	}

	public void setPrintingPeriod(Date printingPeriod) {
		this.printingPeriod = printingPeriod;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Book{" +
			"id=" + id +
			", title=" + title +
			", press=" + press +
			", category=" + category +
			", author=" + author +
			", printingPeriod=" + printingPeriod +
			", no=" + no +
			", price=" + price +
			", createTime=" + createTime +
			"}";
	}
}
