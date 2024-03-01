package com.turkcell.kodlama_io_devs.dataAccess.abstracts;

import com.turkcell.kodlama_io_devs.entities.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {
    void add(ProgrammingLanguage programmingLanguage);
    void delete (int id);
    void update(ProgrammingLanguage programmingLanguage);
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id);
}
