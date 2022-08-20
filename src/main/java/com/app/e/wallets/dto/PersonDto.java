package com.app.e.wallets.dto;

import java.util.Date;

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
public class PersonDto extends EWalletsPersistentObjectDto {

	private String name;
	private String surname;
	private String dni;
	private String email;
	private String phoneNumber;
	private String photo;
	private Date dateBirth;
	private boolean enabled;
}
