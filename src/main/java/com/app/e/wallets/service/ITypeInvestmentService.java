package com.app.e.wallets.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.e.wallets.dto.TypeInvestmentDto;
import com.app.e.wallets.exceptions.BadRequestException;
import com.app.e.wallets.exceptions.ResourceNotFoundException;

public interface ITypeInvestmentService {
	public List<TypeInvestmentDto> listAllTypeInvestment();

	public Page<TypeInvestmentDto> pageTypeInvestment(Pageable pageable);

	public TypeInvestmentDto getTypeInvestmentById(Long idTypeInvestment) throws ResourceNotFoundException;

	public TypeInvestmentDto createTypeInvestment(TypeInvestmentDto typeInvestmentDto);

	public TypeInvestmentDto updateTypeInvestment(TypeInvestmentDto typeInvestmentDto)
			throws ResourceNotFoundException, BadRequestException;

	public void deleteTypeInvestmentById(Long idTypeInvestment) throws ResourceNotFoundException;
}
