package softuni.Mobilele.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import softuni.Mobilele.model.service.MaintenanceInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LocaleChangeInterceptor localeChangeInterceptor;

    private final MaintenanceInterceptor maintenanceInterceptor;

    public WebConfig(LocaleChangeInterceptor localeChangeInterceptor,
                     MaintenanceInterceptor maintenanceInterceptor) {
        this.localeChangeInterceptor = localeChangeInterceptor;
        this.maintenanceInterceptor = maintenanceInterceptor;
    }

//    @Override
    public void addInterceptor(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(maintenanceInterceptor);
    }
}
