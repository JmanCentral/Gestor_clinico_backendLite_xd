package com.gestor.clinia.gestorclinia.persistencie.token;


import com.gestor.clinia.gestorclinia.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t WHERE t.user.id = :userId AND (t.expired = false AND t.revoked = false)")
    List<Token> findAllValidTokensByUser(Long userId);
}
