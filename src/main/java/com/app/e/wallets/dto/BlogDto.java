package com.app.e.wallets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BlogDto extends EWalletsPersistentObjectDto {

	private String title;
	private String summary;
	private String content;
	private String image;
	private Long typeInvestmentId;
	private Boolean enabled;

}
