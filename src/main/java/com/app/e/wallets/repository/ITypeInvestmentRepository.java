package com.app.e.wallets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.e.wallets.entities.TypeInvestment;

@Repository
public interface ITypeInvestmentRepository extends JpaRepository<TypeInvestment, Long> {

}
