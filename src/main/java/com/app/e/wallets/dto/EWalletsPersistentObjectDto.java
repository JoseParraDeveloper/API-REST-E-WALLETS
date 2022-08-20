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
public class EWalletsPersistentObjectDto {

	private Long id;
	private Integer version;
	private Date modificationTimestamp;
	private Date creationTimestamp;
}
