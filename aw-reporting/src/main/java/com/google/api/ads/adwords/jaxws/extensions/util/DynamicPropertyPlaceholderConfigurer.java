package com.google.api.ads.adwords.jaxws.extensions.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * This class is used to inject dynamic resource files into the Spring application context
 *
 * @author gustavomoreira@google.com (Gustavo Moreira)
 */
public class DynamicPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

  private static Resource dynamicResource;

  /**
   * Constructor.
   *
   * Populates the location of the property place holder, with the statically set location.
   */
  public DynamicPropertyPlaceholderConfigurer() {

    if (DynamicPropertyPlaceholderConfigurer.dynamicResource != null) {
      this.setLocation(DynamicPropertyPlaceholderConfigurer.dynamicResource);
    }
  }

  /**
   * Sets the location of the resource that will be recovered dynamically by the container.
   *
   * @param dynamicResource the dynamicResource to set
   */
  public static void setDynamicResource(Resource dynamicResource) {

    if (DynamicPropertyPlaceholderConfigurer.dynamicResource == null) {
      DynamicPropertyPlaceholderConfigurer.dynamicResource = dynamicResource;
    }
  }

}
