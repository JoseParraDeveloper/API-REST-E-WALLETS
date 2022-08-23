package com.app.e.wallets.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.e.wallets.dto.TypeInvestmentDto;
import com.app.e.wallets.exceptions.BadRequestException;
import com.app.e.wallets.exceptions.ResourceNotFoundException;
import com.app.e.wallets.service.ITypeInvestmentService;

@RestController
@RequestMapping(value = "/api/typeInvestment/v1")
public class TypeInvestmentRestController {
	@Autowired
	private ITypeInvestmentService typeInvestmentService;

	@Value("${sizePageTypeInvestment}")
	private int sizePageTypeInvestment;

	@GetMapping(value = "/all")
	public ResponseEntity<List<TypeInvestmentDto>> getAllTypeInvestment() {
		List<TypeInvestmentDto> listTypeInvestmentDto = typeInvestmentService.listAllTypeInvestment();
		if (listTypeInvestmentDto.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listTypeInvestmentDto);
	}

	@GetMapping(value = "/page/{page}")
	public ResponseEntity<Page<TypeInvestmentDto>> pageTypeInvestment(@PathVariable Integer page) {
		Page<TypeInvestmentDto> pageTypeInvestmentDto = typeInvestmentService
				.pageTypeInvestment(PageRequest.of(page - 1, sizePageTypeInvestment));
		if (pageTypeInvestmentDto.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(pageTypeInvestmentDto);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<TypeInvestmentDto> createTypeInvestment(@RequestBody TypeInvestmentDto typeInvestmentDto) {
		return ResponseEntity.ok(typeInvestmentService.createTypeInvestment(typeInvestmentDto));
	}

	@GetMapping(value = "{typeInvestmentId}")
	public ResponseEntity<?> getTypeInvestmentById(@PathVariable("typeInvestmentId") Long typeInvestmentId) {
		try {
			TypeInvestmentDto typeInvestmentDto = typeInvestmentService.getTypeInvestmentById(typeInvestmentId);
			return ResponseEntity.ok(typeInvestmentDto);
		} catch (ResourceNotFoundException resourceNotFoundException) {
			return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{typeInvestmentId}")
	public ResponseEntity<?> deleteTypeInvestment(@PathVariable("typeInvestmentId") Long typeInvestmentId) {
		try {
			typeInvestmentService.deleteTypeInvestmentById(typeInvestmentId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException resourceNotFoundException) {
			return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateTypeInvestment(@RequestBody TypeInvestmentDto typeInvestmentDto) {
		try {
			TypeInvestmentDto updateTypeInvestmentDto = typeInvestmentService.updateTypeInvestment(typeInvestmentDto);
			return new ResponseEntity<>(updateTypeInvestmentDto, HttpStatus.OK);
		} catch (ResourceNotFoundException resourceNotFoundException) {
			return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		} catch (BadRequestException badRequestException) {
			return new ResponseEntity<>(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
