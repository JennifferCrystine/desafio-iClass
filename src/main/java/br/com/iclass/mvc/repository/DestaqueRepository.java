package br.com.iclass.mvc.repository;


import br.com.iclass.mvc.entity.ItemPersonagem;
import br.com.iclass.mvc.entity.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DestaqueRepository extends JpaRepository<Personagem, Long> {
    @Transactional(readOnly = true)
    @Query("select max(experiencia) from Personagem")
    //@Query("select experiencia from Personagem limit got 3 order by experiencia desc")
    void exibeMaioresExperiencias();

}
