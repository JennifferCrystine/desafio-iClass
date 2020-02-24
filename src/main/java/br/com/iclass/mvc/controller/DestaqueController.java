package br.com.iclass.mvc.controller;

import br.com.iclass.mvc.entity.Personagem;
import br.com.iclass.mvc.repository.DestaqueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DestaqueController  {
    List<DestaqueRepository> destaques = new ArrayList<>();

    @RequestMapping(value = "/exibeMaioresExperiencias", method = RequestMethod.GET)
    public void exibeMaioresExperiencias() {


   }


}
