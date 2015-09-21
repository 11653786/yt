package com.yt.entity.base;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Resource;
import javax.persistence.*;

/**
 * Created by user on 2015/8/21.
 */
@Entity
@Table(name = "book")
public class book {
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(name = "book_id", insertable = true, updatable = true, nullable = false)
    private String bookId;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "book_sales")
    private String bookSales;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSales() {
        return bookSales;
    }

    public void setBookSales(String bookSales) {
        this.bookSales = bookSales;
    }


}
