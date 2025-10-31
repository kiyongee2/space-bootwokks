package com.jwbook2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data  //getter, setter, tostring 포함
public class Product {
	//제약 사항 메시지: 비어있을 수 없습니다.
	@NotEmpty(message = "품명은 필수 항목입니다.")
	private String name; //상품명
	
	//0 이상이어야 합니다.
	@Min(value=0, message = "가격은 0원 이상이어야 합니다.")
	private int price;   //가격
}
