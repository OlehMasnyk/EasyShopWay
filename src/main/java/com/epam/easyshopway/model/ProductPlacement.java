package com.epam.easyshopway.model;

import com.epam.easyshopway.dao.transformer.annotation.Column;

public class ProductPlacement {
	@Column("id")
	private Integer id;

	@Column("product_id")
	private Integer productId;

	@Column("cupboard_id")
	private Integer cupboardId;

	@Column("x_start")
	private Integer xStart;

	@Column("y_start")
	private Integer yStart;

	@Column("x_end")
	private Integer xEnd;

	@Column("y_end")
	private Integer yEnd;

	@Column("board_number")
	private Integer boardNumber;

	public ProductPlacement() {
		super();
	}

	public ProductPlacement(Integer id, Integer productId, Integer cupboardId, Integer xStart, Integer yStart,
			Integer xEnd, Integer yEnd, Integer boardNumber) {
		super();
		this.id = id;
		this.productId = productId;
		this.cupboardId = cupboardId;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.boardNumber = boardNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCupboardId() {
		return cupboardId;
	}

	public void setCupboardId(Integer cupboardId) {
		this.cupboardId = cupboardId;
	}

	public Integer getxStart() {
		return xStart;
	}

	public void setxStart(Integer xStart) {
		this.xStart = xStart;
	}

	public Integer getyStart() {
		return yStart;
	}

	public void setyStart(Integer yStart) {
		this.yStart = yStart;
	}

	public Integer getxEnd() {
		return xEnd;
	}

	public void setxEnd(Integer xEnd) {
		this.xEnd = xEnd;
	}

	public Integer getyEnd() {
		return yEnd;
	}

	public void setyEnd(Integer yEnd) {
		this.yEnd = yEnd;
	}

	public Integer getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(Integer boardNumber) {
		this.boardNumber = boardNumber;
	}
}
