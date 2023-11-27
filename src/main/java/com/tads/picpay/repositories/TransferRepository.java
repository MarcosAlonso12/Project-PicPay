package com.tads.picpay.repositories;

import com.tads.picpay.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository <Transfer, Long> {
}
