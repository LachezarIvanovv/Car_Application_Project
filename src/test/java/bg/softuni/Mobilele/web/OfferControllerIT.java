package bg.softuni.Mobilele.web;

import bg.softuni.Mobilele.util.TestDataUtils;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import softuni.Mobilele.model.entity.OfferEntity;
import softuni.Mobilele.model.entity.UserEntity;


import java.util.Locale;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class OfferControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestDataUtils testDataUtils;

    private UserEntity testUser, testAdmin;

    private OfferEntity testOffer, testAdminOffer;

    @BeforeEach
    void setUp(){
        testUser = testDataUtils.createTestUser("user@example.com");
        testAdmin = testDataUtils.createTestAdmin("admin@example.com");
        var testModel = testDataUtils.createTestModel(testDataUtils.createTestBrand());

        testOffer = testDataUtils.createTestOffer(testUser, testModel);
        testAdminOffer = testDataUtils.createTestOffer(testAdmin, testModel);
    }

    @AfterEach
    void tearDown(){
        testDataUtils.cleanUpDatabase();
    }

    @Test
    void testDeleteByAnonymousUser_Forbidden() throws Exception {
        mockMvc.perform(delete("/offers/{id}")
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection());
                //TODO: check redirection url to login without schema

    }

    @Test
    @WithMockUser(
            username = "admin@example.com",
            roles = {"ADMIN", "USER"}
                )
    void testDeleteByAdmin() throws Exception {
        mockMvc.perform(delete("/offers/{id}")
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/offers/all"));
    }

    @Test
    @WithMockUser(
            username = "user@example.com",
            roles = "USER"
    )
    void testDeleteByOwner() throws Exception {
        mockMvc.perform(delete("/offers/{id}")
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/offers/all"));
    }

    @Test
    @WithMockUser(
            username = "user@example.com",
            roles = "USER"
    )
    void testDeleteByNotOwned_Forbidden() throws Exception {
        mockMvc.perform(delete("/offers/{id}", testAdminOffer.getId())
                        .with(csrf())
                )
                .andExpect(status().isForbidden());
    }

    @WithUserDetails("user@example.com")
    @Test
    void testAddOffer() throws Exception {

        mockMvc.perform(post("/offers/add")
                        .param("modelId", "1")
                        .param("price", "11200")
                        .param("engine", "GASOLINE")
                        .param("year", "1979")
                        .param("mileage", "1000")
                        .param("description", "test")
                        .param("imageUrl", "image://test.png")
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}
