package com.google.api.ads.adwords.jaxws.extensions.kratu.restserver;

//import com.google.api.ads.adwords.jaxws.extensions.kratu.data.Account;

import com.google.api.ads.adwords.jaxws.extensions.kratu.data.Account;

import org.restlet.data.Status;
import org.restlet.representation.Representation;

import java.util.List;

//import java.util.List;

/**
 * AccountRest
 * 
 * @author jtoledo@google.com (Julian Toledo)
 */
public class AccountRest extends AbstractServerResource {
  
  public Representation getHandler() {
    String result = null;
    try {
      getParameters();

      List<Account> listAccounts = getStorageHelper().getEntityPersister().get(Account.class);
      result =  gson.toJson(listAccounts);

    } catch (Exception exception) {
      return handleException(exception);
    }
    addReadOnlyHeaders();
    return createJsonResult(result);
  }

  public void deleteHandler() {
    this.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);
  }
  
  public Representation postPutHandler(String json) {
    this.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);
    return createJsonResult(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED.getDescription());
  }
}
