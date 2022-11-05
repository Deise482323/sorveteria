package com.br.sorveteria.repository;

import com.br.sorveteria.entity.Sorvete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SorveteRepository extends JpaRepository<Sorvete, Long> {
}
