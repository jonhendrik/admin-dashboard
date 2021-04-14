package com.jhm.admdash.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhm.admdash.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
