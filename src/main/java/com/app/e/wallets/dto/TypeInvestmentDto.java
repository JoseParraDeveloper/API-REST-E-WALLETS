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

	private static final long serialVersionUID = 1779005836846983028L;
	private String title;
	private String description;

}
