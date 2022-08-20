package com.app.e.wallets.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Person extends EWalletsPersistentObject {

	@Column(length = 20, nullable = false)
	@NotBlank
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ\s]*")
	private String name;
	@Column(length = 20, nullable = false)
	@NotBlank
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ\s]*")
	private String surname;
	@Column(unique = true)
	@Pattern(regexp = "^[0-9]*$")
	private String dni;
	@Column(unique = true)
	@NotBlank
	@Email
	private String email;
	@Pattern(regexp = "^[0-9,+,\s]*$")
	private String phoneNumber;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private String photo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateBirth;
	@Column()
	private boolean enabled;

}
