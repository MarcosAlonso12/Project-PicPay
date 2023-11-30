package com.tads.picpay.repositories;

import com.tads.picpay.entities.UserCommon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCommonRepository extends JpaRepository<UserCommon, Long> {
}

