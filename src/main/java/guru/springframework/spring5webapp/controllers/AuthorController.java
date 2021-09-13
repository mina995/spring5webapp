package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.respositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());
        return "authors";

    }

}
