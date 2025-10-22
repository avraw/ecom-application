package com.app.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecom.dto.AddressDTO;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.Address;
import com.app.ecom.model.User;
import com.app.ecom.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
  


    public List<UserResponse> addUser( UserRequest userRequest) {
        
        System.out.println(userRequest.toString());
        System.out.println(mapToUser(userRequest));
        userRepository.save(mapToUser(userRequest));
        return userRepository.findAll().stream()
                .map(this::mapToUserResponse)
                .toList();
    }
    public List<UserResponse> getAllUsers() {
        
        return userRepository.findAll().stream()
                .map(this::mapToUserResponse)
                .toList();
    }
    
    public Optional<UserResponse> getUserById(Long id) {
        return userRepository.findById(id).map(this::mapToUserResponse);

       }


       public Optional<UserResponse> updateUserById(Long id, UserRequest userRequest) {

        User updatedUser = mapToUser(userRequest);
        return (userRepository.findById(id).map(existingUser -> {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            userRepository.save(existingUser);
            return mapToUserResponse(existingUser);
        }));
       
       }

       private UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId().toString());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setRole(user.getRole());
        if(user.getAddress() != null)   {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setState(user.getAddress().getState());  
            addressDTO.setZipCode(user.getAddress().getZipCode());
            addressDTO.setCountry(user.getAddress().getCountry());
            userResponse.setAddressDTO(addressDTO);
        }
        return userResponse;
        }

       private User mapToUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        
        if(userRequest.getAddress() != null) {
            Address address = new Address();
            address.setStreet(userRequest.getAddress().getStreet());
            address.setCity(userRequest.getAddress().getCity());
            address.setState(userRequest.getAddress().getState());
            address.setZipCode(userRequest.getAddress().getZipCode());
            address.setCountry(userRequest.getAddress().getCountry());
            user.setAddress(address);
        }
        return user;
       }
        
}