package com.google.api.ads.adwords.jaxws.extensions.report.model.persistence;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.AuthMcc;

/**
 * The persister interface for the authorization token.
 *
 *  It is responsibility of the implementation to decide where the authentication will be persisted,
 * and how it will be retrieved.
 *
 * @author gustavomoreira@google.com (Gustavo Moreira)
 */
public interface AuthTokenPersister {

  /**
   * Persists the token.
   *
   * @param authToken the authentication token.
   */
  void persistAuthToken(AuthMcc authToken);

  /**
   * Retrieves the authentication token.
   *
   * @param mccAccountId the top level MCC account ID.
   * @return the authorization token, or null if not found for the account ID.
   */
  AuthMcc getAuthToken(String mccAccountId);

}
