package entity;

import java.util.Date;

/**
 * 实体类 Record
 */

public class Record {
    private int id;
    private int num;
    private String comment1;
    private String comment2;
    private String comment3;
    private String comment4;
    private String comment5;
    private Date date;

    public Record() {
    }

    public Record(int id,int num,String comment1, String comment2, String comment3, String comment4, String comment5, Date date) { 
        this.id = id;
        this.num = num;
        this.comment1 = comment1;
        this.comment2 = comment2;
        this.comment3 = comment3;
        this.comment4 = comment4;
        this.comment5 = comment5;
        this.date = date;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getComment3() {
		return comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getComment4() {
		return comment4;
	}

	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}

	public String getComment5() {
		return comment5;
	}

	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	} 
     
}
