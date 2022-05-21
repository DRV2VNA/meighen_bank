package io.meighen_bank_presenter.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.meighen_bank_presenter.entity.Role;
import io.meighen_bank_presenter.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class JwtUserFactoryTest {
    /**
     * Method under test: {@link JwtUserFactory#create(User)}
     */
    @Test
    void testCreate() {
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
        JwtUser actualCreateResult = JwtUserFactory.create(user);
        Collection<? extends GrantedAuthority> authorities = actualCreateResult.getAuthorities();
        assertEquals(2, authorities.size());
        assertEquals("iloveyou", actualCreateResult.getPassword());
        assertEquals("janedoe", actualCreateResult.getUsername());
        assertEquals("ROLE_USER", ((List<? extends GrantedAuthority>) authorities).get(1).toString());
        assertEquals("Name", ((List<? extends GrantedAuthority>) authorities).get(0).toString());
    }

    /**
     * Method under test: {@link JwtUserFactory#create(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: A granted authority textual representation is required
        //       at org.springframework.util.Assert.hasText(Assert.java:289)
        //       at org.springframework.security.core.authority.SimpleGrantedAuthority.<init>(SimpleGrantedAuthority.java:38)
        //       at io.meighen_bank_presenter.security.JwtUserFactory.create(JwtUserFactory.java:31)
        //   In order to prevent create(User)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   create(User).
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(123L);
        role.setName("");

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
        JwtUserFactory.create(user);
    }
}

