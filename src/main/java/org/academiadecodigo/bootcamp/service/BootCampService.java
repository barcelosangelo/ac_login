package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;

public interface BootCampService {

    Bootcamp findById(int id);

    void addBootCamp(Bootcamp bootcamp);

    void addCodeCadet(CodeCadet codeCadet, int id);

    void findCodeCadet(CodeCadet codeCadet);

    void listBootCamps(Bootcamp bootcamp);




}
