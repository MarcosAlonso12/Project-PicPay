package com.tads.picpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Shopkeeper extends JpaRepository<Shopkeeper, Long> {
}
