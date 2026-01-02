package com.mscompany.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Companies , Long> {
}
