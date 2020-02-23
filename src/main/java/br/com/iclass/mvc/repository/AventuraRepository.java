package br.com.iclass.mvc.repository;

import br.com.iclass.mvc.entity.Aventura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AventuraRepository extends JpaRepository<Aventura, Integer> {

}
