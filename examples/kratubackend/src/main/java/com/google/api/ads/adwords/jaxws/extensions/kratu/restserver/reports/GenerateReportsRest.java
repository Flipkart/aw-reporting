//Copyright 2012 Google Inc. All Rights Reserved.
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

package com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports;

import com.google.api.ads.adwords.jaxws.extensions.kratu.data.RunnableReport;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.AbstractServerResource;

import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.service.TaskService;

/**
 * 
 * @author jtoledo
 * 
 */
public class GenerateReportsRest extends AbstractServerResource {
  
  static TaskService taskService = new TaskService();
  
  public Representation getHandler() {
    String result = null;
    try {
      getParameters();
      
      if (dateStart != null && dateEnd != null ) { //Generate Reports at MCC level for dates

        getContext().getParameters().add("maxThreads", "512");

        // Launching a new Service(Thread) to make the request async.
        RunnableReport runnableReport = new RunnableReport(file, dateStart, dateEnd);
        taskService.submit(runnableReport);

        result = "OK - Task created, this usually takes 10-15mins for 1000 accounts/month";
      } else {
        taskService.getContext();
      }
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