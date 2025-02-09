package com.pcagrade.retriever;

import com.pcagrade.mason.jpa.repository.EnableMasonRevisionRepositories;
import com.pcagrade.mason.jpa.revision.RevisionInfo;
import com.pcagrade.painer.client.EnablePainter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnablePainter
@EnableCaching
@EnableMasonRevisionRepositories
@EntityScan(basePackageClasses = {ProfessionalCardRetriever.class, RevisionInfo.class})
@EnableJpaRepositories // Ajout de cette annotation
//@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
public class ProfessionalCardRetriever {

	public static void main(String[] args) {
		SpringApplication.run(ProfessionalCardRetriever.class, args);
	}
}
