package io.meighen_bank_presenter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.meighen_bank_presenter.dto.UserDto;
import io.meighen_bank_presenter.entity.Role;
import io.meighen_bank_presenter.entity.User;
import io.meighen_bank_presenter.exception.NotFoundException;
import io.meighen_bank_presenter.exception.UserNotFoundExeption;
import io.meighen_bank_presenter.payload.UserDtoPayload;
import io.meighen_bank_presenter.repository.RoleRepository;
import io.meighen_bank_presenter.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#passwordEncoder()}
     */
    @Test
    void testPasswordEncoder() {
        this.userService.passwordEncoder();
    }

    /**
     * Method under test: {@link UserService#findByUsername(String)}
     */
    @Test
    void testFindByUsername() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        Optional<User> actualFindByUsernameResult = this.userService.findByUsername("janedoe");
        assertSame(ofResult, actualFindByUsernameResult);
        assertTrue(actualFindByUsernameResult.isPresent());
        verify(this.userRepository, atLeast(1)).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#findByUsername(String)}
     */
    @Test
    void testFindByUsername2() {
        Optional<User> emptyResult = Optional.empty();
        when(this.userRepository.findByUsername((String) any())).thenReturn(emptyResult);
        Optional<User> actualFindByUsernameResult = this.userService.findByUsername("janedoe");
        assertSame(emptyResult, actualFindByUsernameResult);
        assertFalse(actualFindByUsernameResult.isPresent());
        verify(this.userRepository, atLeast(1)).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#findByUsername(String)}
     */
    @Test
    void testFindByUsername3() {
        when(this.userRepository.findByUsername((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.userService.findByUsername("janedoe"));
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#findUserByUsername(String)}
     */
    @Test
    void testFindUserByUsername() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertSame(user, this.userService.findUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#findUserByUsername(String)}
     */
    @Test
    void testFindUserByUsername2() {
        when(this.userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundExeption.class, () -> this.userService.findUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#findUserByUsername(String)}
     */
    @Test
    void testFindUserByUsername3() {
        when(this.userRepository.findByUsername((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.userService.findUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#findUserById(long)}
     */
    @Test
    void testFindUserById() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(user, this.userService.findUserById(123L));
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#findUserById(long)}
     */
    @Test
    void testFindUserById2() {
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundExeption.class, () -> this.userService.findUserById(123L));
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#findUserById(long)}
     */
    @Test
    void testFindUserById3() {
        when(this.userRepository.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.userService.findUserById(123L));
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#findById(Long)}
     */
    @Test
    void testFindById() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<User> actualFindByIdResult = this.userService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.userRepository, atLeast(1)).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#findById(Long)}
     */
    @Test
    void testFindById2() {
        Optional<User> emptyResult = Optional.empty();
        when(this.userRepository.findById((Long) any())).thenReturn(emptyResult);
        Optional<User> actualFindByIdResult = this.userService.findById(123L);
        assertSame(emptyResult, actualFindByIdResult);
        assertFalse(actualFindByIdResult.isPresent());
        verify(this.userRepository, atLeast(1)).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#findById(Long)}
     */
    @Test
    void testFindById3() {
        when(this.userRepository.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.userService.findById(123L));
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    void testActivateUser() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setActivationCode("Activation Code");
        user1.setCards(new ArrayList<>());
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setRole(role1);
        user1.setSecondName("Second Name");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUserTransactions(new ArrayList<>());
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findByActivationCode((String) any())).thenReturn(ofResult);
        this.userService.activateUser("secret");
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findByActivationCode((String) any());
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    void testActivateUser2() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.save((User) any())).thenThrow(new NotFoundException("An error occurred"));
        when(this.userRepository.findByActivationCode((String) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.userService.activateUser("secret"));
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findByActivationCode((String) any());
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    void testActivateUser3() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findByActivationCode((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.userService.activateUser("secret"));
        verify(this.userRepository).findByActivationCode((String) any());
    }

    /**
     * Method under test: {@link UserService#createNewUserAndFillBasicFields(io.meighen_bank_presenter.payload.BasicPayload)}
     */
    @Test
    void testCreateNewUserAndFillBasicFields() {
        User actualCreateNewUserAndFillBasicFieldsResult = this.userService
                .createNewUserAndFillBasicFields(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                        "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
        assertEquals("janedoe", actualCreateNewUserAndFillBasicFieldsResult.getUsername());
        assertEquals("Second Name", actualCreateNewUserAndFillBasicFieldsResult.getSecondName());
        assertEquals("4105551212", actualCreateNewUserAndFillBasicFieldsResult.getPhoneNumber());
        assertEquals("Doe", actualCreateNewUserAndFillBasicFieldsResult.getLastName());
        assertEquals("Jane", actualCreateNewUserAndFillBasicFieldsResult.getFirstName());
        assertEquals("jane.doe@example.org", actualCreateNewUserAndFillBasicFieldsResult.getEmail());
    }

    /**
     * Method under test: {@link UserService#createNewUserAndFillBasicFields(io.meighen_bank_presenter.payload.BasicPayload)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateNewUserAndFillBasicFields2() {

        this.userService.createNewUserAndFillBasicFields(null);
    }

    /**
     * Method under test: {@link UserService#findByEmail(String)}
     */
    @Test
    void testFindByEmail() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        Optional<User> actualFindByEmailResult = this.userService.findByEmail("jane.doe@example.org");
        assertSame(ofResult, actualFindByEmailResult);
        assertTrue(actualFindByEmailResult.isPresent());
        verify(this.userRepository, atLeast(1)).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#findByEmail(String)}
     */
    @Test
    void testFindByEmail2() {
        Optional<User> emptyResult = Optional.empty();
        when(this.userRepository.findByEmail((String) any())).thenReturn(emptyResult);
        Optional<User> actualFindByEmailResult = this.userService.findByEmail("jane.doe@example.org");
        assertSame(emptyResult, actualFindByEmailResult);
        assertFalse(actualFindByEmailResult.isPresent());
        verify(this.userRepository, atLeast(1)).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#findByEmail(String)}
     */
    @Test
    void testFindByEmail3() {
        when(this.userRepository.findByEmail((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.userService.findByEmail("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#convertUserToUserDto(User)}
     */
    @Test
    void testConvertUserToUserDto() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        UserDto actualConvertUserToUserDtoResult = this.userService.convertUserToUserDto(user);
        assertEquals("jane.doe@example.org", actualConvertUserToUserDtoResult.getEmail());
        assertEquals("janedoe", actualConvertUserToUserDtoResult.getUsername());
        assertEquals("Second Name", actualConvertUserToUserDtoResult.getSecondName());
        assertEquals("Name", actualConvertUserToUserDtoResult.getRole());
        assertEquals("4105551212", actualConvertUserToUserDtoResult.getPhoneNumber());
        assertEquals("Doe", actualConvertUserToUserDtoResult.getLastName());
        assertEquals(123L, actualConvertUserToUserDtoResult.getId());
        assertEquals("Jane", actualConvertUserToUserDtoResult.getFirstName());
    }

    /**
     * Method under test: {@link UserService#registerNewUser(UserDtoPayload)}
     */
    @Test
    void testRegisterNewUser() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        Optional<Role> ofResult = Optional.of(role1);
        when(this.roleRepository.findById((Long) any())).thenReturn(ofResult);
        UserDto actualRegisterNewUserResult = this.userService.registerNewUser(new UserDtoPayload("Jane", "Second Name",
                "Doe", "janedoe", "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example"));
        assertEquals("jane.doe@example.org", actualRegisterNewUserResult.getEmail());
        assertEquals("janedoe", actualRegisterNewUserResult.getUsername());
        assertEquals("Second Name", actualRegisterNewUserResult.getSecondName());
        assertEquals("Name", actualRegisterNewUserResult.getRole());
        assertEquals("4105551212", actualRegisterNewUserResult.getPhoneNumber());
        assertEquals("Doe", actualRegisterNewUserResult.getLastName());
        assertEquals(0L, actualRegisterNewUserResult.getId());
        assertEquals("Jane", actualRegisterNewUserResult.getFirstName());
        verify(this.userRepository).save((User) any());
        verify(this.roleRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#registerNewUser(UserDtoPayload)}
     */
    @Test
    void testRegisterNewUser2() {
        when(this.userRepository.save((User) any())).thenThrow(new NotFoundException("An error occurred"));

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        Optional<Role> ofResult = Optional.of(role);
        when(this.roleRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class,
                () -> this.userService.registerNewUser(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                        "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
        verify(this.userRepository).save((User) any());
        verify(this.roleRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#registerNewUser(UserDtoPayload)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterNewUser3() {

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.roleRepository.findById((Long) any())).thenReturn(Optional.empty());
        this.userService.registerNewUser(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example"));
    }

    /**
     * Method under test: {@link UserService#registerNewUser(UserDtoPayload)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterNewUser4() {


        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        Optional<Role> ofResult = Optional.of(role1);
        when(this.roleRepository.findById((Long) any())).thenReturn(ofResult);
        this.userService.registerNewUser(new UserDtoPayload());
    }

    /**
     * Method under test: {@link UserService#registerNewUser(UserDtoPayload)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterNewUser5() {

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        Optional<Role> ofResult = Optional.of(role1);
        when(this.roleRepository.findById((Long) any())).thenReturn(ofResult);
        this.userService.registerNewUser(null);
    }

    /**
     * Method under test: {@link UserService#findUserByEmail(String)}
     */
    @Test
    void testFindUserByEmail() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        assertSame(user, this.userService.findUserByEmail("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#findUserByEmail(String)}
     */
    @Test
    void testFindUserByEmail2() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.userService.findUserByEmail("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#findUserByEmail(String)}
     */
    @Test
    void testFindUserByEmail3() {
        when(this.userRepository.findByEmail((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.userService.findUserByEmail("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }
}

