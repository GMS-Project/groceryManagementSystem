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
@Table(name = "Products") 
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;
	
	@Column(name="product_name",length =20)
	private String productName;  //PID	PNAME	PRATE	PEXPDATE	PMANFACT	CATID
	
	@Column(name="product_desc",length =100)
	private String productDesc;

	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="product_mfgdate")
	private LocalDate productMfgDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="product_expdate")
	private LocalDate productExpDate;
	
	
	@Column(name="product_price")
	private double productPrice ;
	
//	@Column(name="product_quantity")
//	private int productQuantity ;
	
	//@Column(length =30)
	//private String pmanufacturer;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)//MERGE : NEW n INTERESTING !!!!!
	@JoinColumn(name = "cat_id") // Optional BUT reco , to specify the name of FK col.
	private Category category;
	
	
	
//	@ManyToMany(cascade = CascadeType.PERSIST) // mandatory!
//	@JoinTable(name="order_products",
//	joinColumns = @JoinColumn(name="product_id"),
//	inverseJoinColumns = @JoinColumn(name="order_id")
//	)
//	private Set<Orders> orders=new HashSet<>();

}
