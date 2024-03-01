package com.turkcell.kodlama_io_devs.controllers;

import com.turkcell.kodlama_io_devs.business.abstracts.ProgrammingLanguageService;
import com.turkcell.kodlama_io_devs.entities.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgrammingLanguageController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping
    public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception{
        programmingLanguageService.add(programmingLanguage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception{
        programmingLanguageService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception{
        programmingLanguageService.update(programmingLanguage);
    }

    @GetMapping("/getall")
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageService.getAll();

    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable(name = "id") int id) throws Exception {
        return programmingLanguageService.getById(id);
    }
}
