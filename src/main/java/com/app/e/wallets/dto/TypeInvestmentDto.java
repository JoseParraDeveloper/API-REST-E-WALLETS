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
public class TypeInvestmentDto extends EWalletsPersistentObjectDto {

	private String title;
	private String description;

}
