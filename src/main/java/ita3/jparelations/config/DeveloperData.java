package ita3.jparelations.config;

import ita3.jparelations.entity.Adress;
import ita3.jparelations.entity.Citizen;
import ita3.jparelations.entity.Town;
import ita3.jparelations.repository.IAdressRepository;
import ita3.jparelations.repository.ICitizenRepository;
import ita3.jparelations.repository.ITownRepository;
import ita3.jparelations.service.AdressService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {
    IAdressRepository adressRepository;
    ICitizenRepository citizenRepository;
    ITownRepository townRepository;
    AdressService adressService;

    public DeveloperData(IAdressRepository adressRepository, ICitizenRepository citizenRepository, ITownRepository townRepository, AdressService adressService){
        this.adressRepository = adressRepository;
        this.citizenRepository = citizenRepository;
        this.townRepository = townRepository;
        this.adressService = adressService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Adress a1 = new Adress("Lyngbyvej 1", 2800, "Lyngby");
        Town town1 = new Town("København",2200,"William","KEA");
        Citizen citizen1 = new Citizen("Kurt", "Wonnegut", "a@b.dk",123, a1,town1);
        Citizen citizen2 = new Citizen("Hanne", "Wonnegut", "h@b.dk", 234, a1,town1);
        System.out.println(citizen2.getTown().getName());
        System.out.println(citizen1.getTown().getName());

        townRepository.save(town1);
        a1.addCitizen(citizen1);
        a1.addCitizen(citizen2);
        adressRepository.save(a1);
        List<Citizen> c1 = citizenRepository.findByTownId(1L);
        System.out.println(c1.get(0).getFirstName());
        System.out.println(c1.get(1).getFirstName());

        /*
        System.out.println("------- Select statements starts here ------ ------");
        Adress address_1 = adressRepository.findById(a1.getId()).get();
        System.out.println(address_1.getStreet());
        System.out.println("Press Enter to continue");
        System.in.read();
        System.out.println("Citizens: "+address_1.getCitizens().size());
        */
        adressService.printFullAddressInfo(a1.getId(),true);

        System.out.println("Citizens: "+ citizenRepository.count());
        a1.getCitizens().remove(citizen1);
        a1.getCitizens().remove(citizen2);
        adressRepository.save(a1);
        System.out.println("Citizens: "+ citizenRepository.count());

    }
}
