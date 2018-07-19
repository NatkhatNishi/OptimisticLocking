package com.sample.rbac.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.rbac.model.Portfolio;
/**
 * @author NishigandhaomanwarOm
 *
 */
@Transactional
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}