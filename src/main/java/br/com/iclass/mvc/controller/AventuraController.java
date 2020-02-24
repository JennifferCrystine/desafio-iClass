package br.com.iclass.mvc.controller;


import br.com.iclass.mvc.entity.Aventura;
import br.com.iclass.mvc.entity.ItemPersonagem;
import br.com.iclass.mvc.entity.Personagem;
import br.com.iclass.mvc.repository.AventuraRepository;
import br.com.iclass.mvc.repository.ItemPersonagemRepository;
import br.com.iclass.mvc.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AventuraController {

    private Aventura aventuraPersonagem;

    private AventuraRepository repository;

    @Autowired
    private PersonagemRepository personagemRepository;

    private List<Personagem> personagens = new ArrayList<>();

    @Autowired
    public AventuraController(AventuraRepository prAventuraRepository) {
        this.repository = prAventuraRepository;
    }


    @RequestMapping(value = "/adicionaAventura", method = RequestMethod.POST)
    public String adicionaAventura(@ModelAttribute @Valid Aventura aventuraPersonagem, BindingResult errors, Model model, Personagem personagem) {

        aventuraPersonagem = new Aventura();

        int xp = aventuraPersonagem.getXp();
        int nivel = personagem.getNivel();
        aventuraPersonagem.setXp(xp++);
        if(xp == (100 * (nivel + 1))) {
            personagem.setNivel(nivel++);
            personagem.setPontos(+1);

            if(nivel % 5 == 0) personagem.setPontos(+2);
            else if(nivel % 10 == 0) personagem.setPontos(+3);

            if( xp > (100 * (nivel + 1))) personagem.setExperiencia(xp);

        }

        if(errors.hasErrors()) {
            model.addAttribute("aventuraPersonagem", aventuraPersonagem);
            return "/paginas/aventura/listarAventuras";
        }

        repository.save(aventuraPersonagem);

        return "redirect:/listarAventuras";
    }



    @RequestMapping(value = "/listarAventuras", method = RequestMethod.GET)
    public String listarAventuras(Model model) {

        personagens = new ArrayList<>();
        personagens = personagemRepository.findAll();
        model.addAttribute("personagens", personagens);

        List<Aventura> listaAventuras = repository.findAll();
        aventuraPersonagem = new Aventura();
        model.addAttribute("aventuraPersonagem", aventuraPersonagem);


        if (listaAventuras != null) {
            model.addAttribute("aventuraPersonagem", aventuraPersonagem);
        }

        return "/paginas/aventura/listarAventuras";
    }
}
