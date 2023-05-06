package ru.netology.hwspringboot.config;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.hwspringboot.profile.DevProfile;
import ru.netology.hwspringboot.profile.ProductionProfile;
import ru.netology.hwspringboot.profile.SystemProfile;

@NoArgsConstructor
@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
