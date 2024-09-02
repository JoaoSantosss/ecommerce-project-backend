package com.ecommerce.project.models.pk;

import java.io.Serializable;

import com.ecommerce.project.models.Order;
import com.ecommerce.project.models.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PKOrderItem implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order orderId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productId;

}
