package com.hasandag.service.impl;


import com.hasandag.dto.PersonDto;
import com.hasandag.entitiy.Address;
import com.hasandag.entitiy.Person;
import com.hasandag.repo.AddressRepository;
import com.hasandag.repo.PersonRepository;
import com.hasandag.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Person person = new Person();

        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        Person personDb = personRepository.save(person);

        List<Address> addressList = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setIsActive(true);
            address.setPerson(person);
            addressList.add(address);
        });
        addressRepository.saveAll(addressList);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        personList.forEach(iter -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(iter.getId());
            personDto.setName(iter.getName());
            personDto.setLastName(iter.getLastName());
            personDto.setAddresses(iter.getAddresses().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));
            personDtos.add(personDto);
        });
        return personDtos;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }

}
