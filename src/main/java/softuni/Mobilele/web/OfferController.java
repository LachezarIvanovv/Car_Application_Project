package softuni.Mobilele.web;

import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.Mobilele.model.dto.AddOfferDTO;
import softuni.Mobilele.model.service.BrandService;
import softuni.Mobilele.model.service.OfferService;


@Controller
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService,
                           BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers(
            Model model,
            @PageableDefault(
                    page = 0,
                    size = 5) Pageable pageable){
        model.addAttribute("offers", offerService.getAllOffers(pageable));
        return "offers";
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model){
        if(!model.containsAttribute("addOfferModel")){
            model.addAttribute("addOfferModel", new AddOfferDTO());
        }
        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferDTO addOfferModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails userDetails){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel",
                    bindingResult);

            return "redirect:/offers/add";
        }


        offerService.addOffer(addOfferModel, userDetails);
        return "redirect:/offers/all";
    }
}
