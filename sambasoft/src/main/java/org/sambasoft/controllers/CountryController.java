package org.sambasoft.controllers;

import org.sambasoft.entities.Country;
import org.sambasoft.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/")
    public String showPage(ModelMap model, @RequestParam(defaultValue = "0") int page) {

        final PageRequest page1 = new PageRequest(
                page, 4, new Sort(
                new Sort.Order(Sort.Direction.ASC, "id")
        )
        );


        model.addAttribute("data", countryRepository.findAll(page1));
        model.addAttribute("currentPage", page);
        return "index";
    }

    @PostMapping("/save")
    public String save(Country country, ModelMap model, Integer currentPage) {
        countryRepository.save(country);
        model.addAttribute("currentPage", currentPage);

        return showPage(model, currentPage);
    }

    @GetMapping("/delete")
    public String delete(Integer id, ModelMap model,  Integer currentPage) {
        countryRepository.delete(id);
        model.addAttribute("currentPage", currentPage);

        final PageRequest page1 = new PageRequest(
                currentPage, 4, new Sort(
                new Sort.Order(Sort.Direction.ASC, "id")
        )
        );


        model.addAttribute("data", countryRepository.findAll(page1));
        model.addAttribute("currentPage", currentPage);
        return "redirect:/?page="+currentPage;
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Country findOne(Integer id) {
        return countryRepository.findOne(id);
    }

}
