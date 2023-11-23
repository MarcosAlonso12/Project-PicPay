package com.tads.picpay.repositories;

import com.tads.picpay.entities.Shopkeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopkeeperRepository extends JpaRepository<Shopkeeper, Long> {
}
