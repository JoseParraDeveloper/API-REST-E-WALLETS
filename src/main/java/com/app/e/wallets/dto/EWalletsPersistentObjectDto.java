package com.app.e.wallets.dto;

import java.io.Serializable;
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
public class EWalletsPersistentObjectDto implements Serializable {

	private static final long serialVersionUID = -4431390134847381823L;
	private Long id;
	private Integer version;
	private Date modificationTimestamp;
	private Date creationTimestamp;

}
