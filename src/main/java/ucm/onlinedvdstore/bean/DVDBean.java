package ucm.onlinedvdstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Store;

import java.util.Date;
@Entity
@Indexed
@Table(name = "DVDCollection")
public class DVDBean {

	
	@Id
	@Column(name = "id")
	private int id;
	
	 @Column(name = "DVDCategory", nullable= false, length = 20)
	   @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	   private String dvdCategory;
	 
	 @Column(name = "DVDName", nullable= false, length = 30)
	   @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	   private String dvdName;
	
	 @Column(name = "DVDDescription", nullable= false, length = 300)
	   @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	   private String dvdDescription;
	 
	 @Column(name = "DVDPrice", nullable= false)
	   @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	   private double dvdPrice;
	 
	 @Column(name = "imagePath", nullable= false,length = 300)
	   @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	   private String imagePath;
	 
	 @Column(name = "createdate", nullable= false)
	   private Date createDate;
	   
	   @Column(name = "updatedate", nullable= false)
	   private Date updateDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDvdCategory() {
		return dvdCategory;
	}

	public void setDvdCategory(String dvdCategory) {
		this.dvdCategory = dvdCategory;
	}

	public String getDvdName() {
		return dvdName;
	}

	public void setDvdName(String dvdName) {
		this.dvdName = dvdName;
	}

	public String getDvdDescription() {
		return dvdDescription;
	}

	public void setDvdDescription(String dvdDescription) {
		this.dvdDescription = dvdDescription;
	}

	public double getDvdPrice() {
		return dvdPrice;
	}

	public void setDvdPrice(double dvdPrice) {
		this.dvdPrice = dvdPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	 
}
