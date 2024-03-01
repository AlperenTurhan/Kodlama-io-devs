package com.turkcell.kodlama_io_devs.business.abstracts;

import com.turkcell.kodlama_io_devs.entities.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    void add(ProgrammingLanguage programmingLanguage) throws Exception;
    void delete (int id) throws Exception;
    void update(ProgrammingLanguage programmingLanguage) throws Exception;
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id) throws Exception;
}
