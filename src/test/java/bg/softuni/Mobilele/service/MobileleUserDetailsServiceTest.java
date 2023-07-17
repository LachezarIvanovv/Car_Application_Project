package bg.softuni.Mobilele.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softuni.Mobilele.model.entity.UserEntity;
import softuni.Mobilele.model.entity.UserRoleEntity;
import softuni.Mobilele.model.enums.UserRoleEnum;
import softuni.Mobilele.model.service.MobileleUserDetailsService;
import softuni.Mobilele.model.user.MobileleUserDetails;
import softuni.Mobilele.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MobileleUserDetailsServiceTest {

    @Mock
    private UserRepository mockUserRepo;

    private MobileleUserDetailsService toTest;

    @BeforeEach
    void setUp(){
        toTest = new MobileleUserDetailsService(mockUserRepo);
    }

    @Test
    void testLoadUserByUsername_UserExists(){
        //Arrange
        UserEntity testUserEntity =
                new UserEntity()
                        .setEmail("test@example.com")
                        .setPassword("topsecret")
                        .setFirstName("Pesho")
                        .setLastName("Petrov")
                        .setActive(true)
                        .setImageUrl("http://image.com/image")
                        .setUserRoles(
                                List.of(
                                        new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN),
                                        new UserRoleEntity().setUserRole(UserRoleEnum.USER)
                                )
                        );

        when(mockUserRepo.findByEmail(testUserEntity.getEmail()))
                .thenReturn(Optional.of(testUserEntity));

        //Act
        MobileleUserDetails userDetails = (MobileleUserDetails)
                toTest.loadUserByUsername(testUserEntity.getEmail());

        //Assert
        Assertions.assertEquals(testUserEntity.getEmail(), userDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getFirstName(), userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(), userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());
        Assertions.assertEquals(testUserEntity.getFirstName() + " " + testUserEntity.getLastName(), userDetails.getFullName());

        var authorities = userDetails.getAuthorities();
        Assertions.assertEquals(2, authorities.size());

        var authoritiesIter = authorities.iterator();

        Assertions.assertEquals("ROLE_" + UserRoleEnum.ADMIN.name(),
                authoritiesIter.next().getAuthority());

        Assertions.assertEquals("ROLE_" + UserRoleEnum.USER.name(),
                authoritiesIter.next().getAuthority());

    }

    @Test
    void testLoadUserByUsername_UserDoesNotExists(){

        //Arrange
        //NOTE: No need to arrange anything, mocks return empty optionals

        //Act & Assert
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername("non-existing@example.com")
        );

    }
}
