package com.app.e.wallets.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Lob;
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
@Table(name = "blogs")
public class Blog extends EWalletsPersistentObject {
	@Column(nullable = false)
	@NotBlank
	private String title;
	@NotBlank
	private String summary;
	@NotBlank
	private String content;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private String image;
	private TypeInvestment typeInvestment;
	private Boolean enabled;

}
