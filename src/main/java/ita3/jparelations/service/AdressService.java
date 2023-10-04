package ita3.jparelations.service;

import ita3.jparelations.entity.Adress;
import ita3.jparelations.repository.IAdressRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    IAdressRepository adressRepository;

    public AdressService(IAdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Transactional
    public void printFullAddressInfo(long id, boolean includeCitizens) {

        Adress address_1 = adressRepository.findById(id).get();
        System.out.println(address_1.getStreet());

        if (includeCitizens) {
            System.out.println("Citizens: " + address_1.getCitizens().size());
        }
    }
}
