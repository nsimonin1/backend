/**
 * 
 */
package org.simon.pascal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

/**
 * @author simon.pascal.ngos
 *
 */
@Configuration
public class CustomRestMvcConfiguration {
	  //@Bean
	  public RepositoryRestConfigurer repositoryRestConfigurer() { 

	    return new RepositoryRestConfigurer() {

	      @Override
	      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	        config.setBasePath("/api");
	      }
	    };
	  }

}
