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
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    @TableId("book_title")
	private String bookTitle;
	private String isbn;
	@TableField("date_of_printing")
	private String dateOfPrinting;
	private String author;
	private String press;
	private String category;
	@TableField("unit_price")
	private Float unitPrice;


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

	public String getDateOfPrinting() {
		return dateOfPrinting;
	}

	public void setDateOfPrinting(String dateOfPrinting) {
		this.dateOfPrinting = dateOfPrinting;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	protected Serializable pkVal() {
		return this.bookTitle;
	}

	@Override
	public String toString() {
		return "Book{" +
			"bookTitle=" + bookTitle +
			", isbn=" + isbn +
			", dateOfPrinting=" + dateOfPrinting +
			", author=" + author +
			", press=" + press +
			", category=" + category +
			", unitPrice=" + unitPrice +
			"}";
	}
}
