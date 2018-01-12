package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.MockBootCampService;
import org.academiadecodigo.bootcamp.utils.Gender;

import java.util.Date;

public class Main2 {

    public static void main(String[] args) {

        Bootcamp bootcamp = new Bootcamp(1,"Praia da Vitória",new Date(30-10-2017),new Date(6-2-2018));
        Bootcamp bootcamp1 = new Bootcamp(2,"Angra do Heroísmo",new Date(30-10-2017),new Date(6-2-2018));
        Bootcamp bootcamp2 = new Bootcamp(2,"Angra do Heroísmo",new Date(30-10-2017),new Date(6-2-2018));

        User user = new User("barcelosangelo","barcelos.angelo@gmail.com","angelo");
        CodeCadet codeCadet = new CodeCadet(user, Gender.MALE,"Praia da Vitória","Praia da Vitória","918839452",bootcamp,new Date(6-11-1977));

        User user1 = new User("diogobrandao,","brandao@gmail.com","brandao");
        CodeCadet codeCadet1 = new CodeCadet(user1,Gender.MALE,"Angra","Angra","966444999",bootcamp,new Date(10-10-1991));
        CodeCadet codeCadet2 = new CodeCadet(user1,Gender.MALE,"Angra","Angra","967 898 664",bootcamp,new Date(10-10-1992));

        bootcamp.addCadet(codeCadet1);
        bootcamp.addCadet(codeCadet2);
        bootcamp.addCadet(codeCadet);
        bootcamp1.addCadet(codeCadet1);

        MockBootCampService mc = new MockBootCampService();
        mc.addBootCamp(bootcamp);
        mc.addBootCamp(bootcamp1);
        mc.addBootCamp(bootcamp2);

        System.out.println(mc.getBootcamps());


       //System.out.println("test" + bootcamp.getCodecadets());

        System.out.println("org/academiadecodigo/bootcamp" + bootcamp.getCodecadets());

        System.out.println("bootcamp1" + bootcamp1.getCodecadets());

        System.out.println();



        bootcamp.addCadet(codeCadet);

        /*System.out.println(codeCadet);
        System.out.println(codeCadet1);
        System.out.println(codeCadet2);
        System.out.println(bootcamp);
        System.out.println(bootcamp1);
        System.out.println(bootcamp2);
        System.out.println(user);
        System.out.println(user1);
        System.out.println(codeCadet1.hashCode());
*/
    }


}
