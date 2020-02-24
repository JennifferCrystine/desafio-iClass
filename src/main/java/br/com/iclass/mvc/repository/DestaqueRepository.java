package br.com.iclass.mvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DestaqueRepository extends JpaRepository {
    @Transactional(readOnly = true)
    @Query("select max(experiencia) from Personagem")
    //@Query("select experiencia from Personagem limit got 3 order by experiencia desc")
    void exibeMaioresExperiencias();

}
