package org.bonn.se.carlook.model.factories;

import org.bonn.se.carlook.model.objects.dto.UserDTO;
import org.bonn.se.carlook.model.objects.entities.User;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserFactory{

    private UserFactory(){}

    public static User createEntity() {
        return new User();
    }

    public static UserDTO createDTO() {
        return new UserDTO();
    }

    public static User createEntityFromDTO(UserDTO dto) {
        //User userEntity = new User();
        //BeanUtil.copyProperties(userDto, userEntity);
        return new User();
    }

    public static UserDTO createDTOFromEntity(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setEMail(entity.getEMail());
        userDTO.setPassword(entity.getPassword());

        return userDTO;
    }
}