package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.dtoClasses.userDto;
import com.Ecommerce.Backend.Application.entities.Address;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.AddressRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class sellerService {

    @Autowired
    AddressRepository addressRepo;

    public ResponseEntity<Object> updateAddress(Long id, userDto dto) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null || !authentication.isAuthenticated())
            return null;
        else {
            User user = (User) authentication.getPrincipal();

            Boolean bool = addressRepo.findById(id).isPresent();

            if (bool == true) {
                Address address = addressRepo.findById(id).get();
                System.out.println("hello");
                System.out.println(user.getId());
                System.out.println(address.getUser().getId());

                if (address.getUser().getId() == user.getId()) {

                    if (dto.getCompany_address().getAddress_line() != null)
                        address.setAddress_line(dto.getCompany_address().getAddress_line());
                    if (dto.getCompany_address().getCity() != null)
                        address.setCity(dto.getCompany_address().getCity());
                    if (dto.getCompany_address().getState() != null)
                        address.setState(dto.getCompany_address().getState());
                    if (dto.getCompany_address().getCountry() != null)
                        address.setCountry(dto.getCompany_address().getCountry());
                    if (dto.getCompany_address().getZip_code() != null)
                        address.setZip_code(dto.getCompany_address().getZip_code());
                    if (dto.getCompany_address().getLabel() != null)
                        address.setLabel(dto.getCompany_address().getLabel());

                    addressRepo.save(address);

                    return ResponseHandler.generateResponse3("Address update Successfully !", HttpStatus.OK, "null");
                }

                return ResponseHandler.generateResponse3("You entered incorrect Address ID", HttpStatus.BAD_REQUEST, "null");

            }

            return ResponseHandler.generateResponse3("You entered wrong Address ID", HttpStatus.BAD_REQUEST, "null");

        }


    }

}
