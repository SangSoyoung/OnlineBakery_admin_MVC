package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
	
	private String pcode;
	private String pname;
	private int price;
	private String storage;
	private String expiration;
	private String description;
	private String img;
	
}



