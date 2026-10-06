package dev.dmitriirussu.petclinic.resource.infrastructure.bootstrap;

import dev.dmitriirussu.petclinic.resource.application.command.repository.*;
import dev.dmitriirussu.petclinic.resource.application.command.service.AllCommandServiceFactory;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.*;
import dev.dmitriirussu.petclinic.resource.infrastructure.command.repository.AllCommandRepositoryFactory;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
class CommandConfig {

    // --- repositories ---
    @Bean
    OwnerCreateRepository ownerCreateRepository(JdbcClient jdbc, CacheManager cacheManager) {
        return AllCommandRepositoryFactory.ownerCreateRepository(jdbc, cacheManager);
    }

    @Bean
    OwnerUpdateRepository ownerUpdateRepository(JdbcClient jdbc, CacheManager cacheManager) {
        return AllCommandRepositoryFactory.ownerUpdateRepository(jdbc, cacheManager);
    }

    @Bean
    PetCreateRepository petCreateRepository(JdbcClient jdbc, CacheManager cacheManager) {
        return AllCommandRepositoryFactory.petCreateRepository(jdbc, cacheManager);
    }

    @Bean
    PetUpdateRepository petUpdateRepository(JdbcClient jdbc, CacheManager cacheManager) {
        return AllCommandRepositoryFactory.petUpdateRepository(jdbc, cacheManager);
    }

    @Bean
    VisitCreateRepository visitCreateRepository(JdbcClient jdbc, CacheManager cacheManager) {
        return AllCommandRepositoryFactory.visitCreateRepository(jdbc, cacheManager);
    }

    // --- use cases ---
    @Bean
    OwnerCreateUseCase ownerCreateUseCase(OwnerCreateRepository createRepository) {
        return AllCommandServiceFactory.ownerCreateUseCase(createRepository);
    }

    @Bean
    OwnerUpdateUseCase ownerUpdateUseCase(OwnerUpdateRepository updateRepository) {
        return AllCommandServiceFactory.ownerUpdateUseCase(updateRepository);
    }

    @Bean
    PetCreateUseCase petCreateUseCase(PetCreateRepository createRepository) {
        return AllCommandServiceFactory.petCreateUseCase(createRepository);
    }

    @Bean
    PetUpdateUseCase petUpdateUseCase(PetUpdateRepository updateRepository) {
        return AllCommandServiceFactory.petUpdateUseCase(updateRepository);
    }

    @Bean
    VisitCreateUseCase visitCreateUseCase(VisitCreateRepository createRepository) {
        return AllCommandServiceFactory.visitCreateUseCase(createRepository);
    }
}