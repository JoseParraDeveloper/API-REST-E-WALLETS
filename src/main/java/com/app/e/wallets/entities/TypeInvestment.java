package com.app.e.wallets.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "types_investments")
public class TypeInvestment extends EWalletsPersistentObject {
	@Column(nullable = false)
	@NotBlank
	private String title;
	@Column(nullable = false)
	@NotBlank
	private String description;

}
