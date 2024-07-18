package com.codingmak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UniqueIdChecker {

    private final ApplicationContext applicationContext;

    @Autowired
    public UniqueIdChecker(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void checkUniqueId(Long id) {
        String[] repositoryBeanNames = applicationContext.getBeanNamesForType(JpaRepository.class);

        for (String beanName : repositoryBeanNames) {
            JpaRepository repository = (JpaRepository) applicationContext.getBean(beanName);
            if (repository.existsById(id)) {
                throw new RuntimeException("ID " + id + " already exists in repository: " + beanName);
            }
        }
    }
}
