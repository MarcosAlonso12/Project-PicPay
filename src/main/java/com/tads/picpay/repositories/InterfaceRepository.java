package com.tads.picpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRepository extends JpaRepository <Transfer, Long> {


}
