package com.app.entities;

import java.time.LocalDate;
import com.app.entities.Category;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name = "SubCategory") 
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SubCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subCat_id")
	private Long subCatId;
	
	@Column(name="subCat_name",length =20)
	private String subCatName;
	
	@Column(name="subCategory_desc",length=250)
	private String subCategoryDesc;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="cat_Id")
	private Category category;
}