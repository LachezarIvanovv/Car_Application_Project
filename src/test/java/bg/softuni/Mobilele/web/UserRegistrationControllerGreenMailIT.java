package bg.softuni.Mobilele.web;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Test.class)
@AutoConfigureMockMvc
public class UserRegistrationControllerGreenMailIT {

    @Value("${mail.host}")
    private String mailHost;
    @Value("1025")
    private Integer mailPort;
    @Value("mobilele@mobilele.com")
    private String username;
    @Value("topsecret")
    private String password;

    @Autowired
    private MockMvc mockMvc;
    private GreenMail greenMail;

    @BeforeEach
    void setUp(){
        greenMail = new GreenMail(new ServerSetup(mailPort, mailHost, "smtp"));
        greenMail.start();
        greenMail.setUser(username, password);
    }

    @AfterEach
    void tearDown(){
        greenMail.stop();
    }

    @Test
    void testRegistration() throws Exception {
        mockMvc.perform(post("/users/register")
                        .param("email", "pesho@example.com")
                        .param("firstName", "Pesho")
                        .param("lastName", "Petrov")
                        .param("password", "topsecret")
                        .param("confirmPassword", "topsecret")
                        .cookie(new Cookie("lang", Locale.GERMAN.getLanguage()))
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        Assertions.assertEquals(1, receivedMessages.length);

        MimeMessage welcomeMessage = receivedMessages[0];
        Assertions.assertTrue(welcomeMessage.getContent().toString().contains("Pesho Petrov"));


    }
}
