package com.app.e.wallets.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.e.wallets.dto.TypeInvestmentDto;
import com.app.e.wallets.entities.TypeInvestment;
import com.app.e.wallets.exceptions.BadRequestException;
import com.app.e.wallets.exceptions.ResourceNotFoundException;
import com.app.e.wallets.repository.ITypeInvestmentRepository;

@Service
public class TypeInvestmentServiceImpl implements ITypeInvestmentService {

	@Autowired
	private ITypeInvestmentRepository typeInvestmentRepository;
	@Autowired
	@Qualifier("modelMapper")
	private ModelMapper modelMapper;

	@Override
	public List<TypeInvestmentDto> listAllTypeInvestment() {
		List<TypeInvestment> listTypesInvestments = typeInvestmentRepository.findAll();
		return listTypesInvestments.stream()
				.map(typeInvestment -> modelMapper.map(typeInvestment, TypeInvestmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Page<TypeInvestmentDto> pageTypeInvestment(Pageable pageable) {
		Page<TypeInvestment> pageTypesInvestments = typeInvestmentRepository.findAll(pageable);
		return new PageImpl<>(pageTypesInvestments.stream()
				.map(typeInvestment -> modelMapper.map(typeInvestment, TypeInvestmentDto.class))
				.collect(Collectors.toList()));
	}

	@Override
	public TypeInvestmentDto getTypeInvestmentById(Long idTypeInvestment) throws ResourceNotFoundException {
		Optional<TypeInvestment> optionalTypeInvestment = typeInvestmentRepository.findById(idTypeInvestment);
		return modelMapper.map(optionalTypeInvestment.orElseThrow(
				() -> new ResourceNotFoundException(TypeInvestment.class.getName(), "id", idTypeInvestment.toString())),
				TypeInvestmentDto.class);
	}

	@Override
	public TypeInvestmentDto createTypeInvestment(TypeInvestmentDto typeInvestmentDto) {
		typeInvestmentDto.setCreationTimestamp(new Date());
		typeInvestmentDto.setCreationTimestamp(new Date());
		TypeInvestment newTypeInvestment = modelMapper.map(typeInvestmentDto, TypeInvestment.class);
		newTypeInvestment = typeInvestmentRepository.save(newTypeInvestment);
		return modelMapper.map(newTypeInvestment, TypeInvestmentDto.class);
	}

	@Override
	public TypeInvestmentDto updateTypeInvestment(TypeInvestmentDto typeInvestmentDto)
			throws ResourceNotFoundException, BadRequestException {
		Long idTypeInvestment = typeInvestmentDto.getId();
		if (idTypeInvestment != null) {
			Optional<TypeInvestment> optionalTypeInvestment = typeInvestmentRepository.findById(idTypeInvestment);
			if (!optionalTypeInvestment.isPresent()) {
				throw new ResourceNotFoundException(TypeInvestment.class.getName(), "id", idTypeInvestment.toString());
			}
		} else {
			throw new BadRequestException("Bad Request");
		}
		return this.createTypeInvestment(typeInvestmentDto);
	}

	@Override
	public void deleteTypeInvestmentById(Long idTypeInvestment) throws ResourceNotFoundException {
		Optional<TypeInvestment> optionalTypeInvestment = typeInvestmentRepository.findById(idTypeInvestment);
		optionalTypeInvestment
				.ifPresentOrElse(deleteTypeInvestment -> typeInvestmentRepository.delete(deleteTypeInvestment), () -> {
					throw new ResourceNotFoundException(TypeInvestment.class.getName(), "id",
							idTypeInvestment.toString());
				});
	}

}
