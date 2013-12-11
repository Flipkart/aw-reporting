package com.google.api.ads.adwords.jaxws.extensions.kratu.restserver;

import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.kratu.GenerateKratusRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.kratu.KratuRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports.GenerateReportsRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports.ReportAccountRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports.ReportAdExtensionRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports.ReportAdGroupRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports.ReportAdRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports.ReportCampaignNegativeKeywordRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports.ReportCampaignRest;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.reports.ReportKeywordRest;

import org.restlet.Application;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.Directory;
import org.restlet.routing.Redirector;
import org.restlet.routing.Router;
import org.springframework.context.ApplicationContext;

/**
 * RestServer
 * 
 * @author jtoledo@google.com (Julian Toledo)
 */
public class RestServer extends Application {

  public static void createRestServer(ApplicationContext appCtx, String propertiesPath) throws Exception {

    // Create a component
    Component component = new Component();
    component.getServers().add(Protocol.HTTP, 8081);
    component.getClients().add(Protocol.FILE);
    component.getClients().add(Protocol.CLAP);

    Context context = component.getContext().createChildContext();
    RestServer application = new RestServer(context);
    
    application.getContext().getParameters().add("useForwardedForHeader", "true");
    
    application.getContext().getAttributes().put("appCtx", appCtx);
    application.getContext().getAttributes().put("file", propertiesPath);

    // Attach the application to the component and start it
    component.getDefaultHost().attach(application);
    component.start();
  }

  private RestServer(Context context) {
    super(context);
  }

  public synchronized Restlet createInboundRoot() {
    Router router = new Router(getContext());
    
    // Accounts
    router.attach("/accounts/", AccountRest.class);

    // *** Reporting ***
    // Generate
    // ?dateStart=yyyyMMdd&dateEnd=yyyyMMdd
    router.attach("/generatereports/", GenerateReportsRest.class);

    // Accounts
    // ?dateStart=yyyyMMdd&dateEnd=yyyyMMdd
    router.attach("/reportaccount/", ReportAccountRest.class); //LIST All
    router.attach("/reportaccount/{accountId}", ReportAccountRest.class); //LIST Account level
    
    // Campaigns
    // ?dateStart=yyyyMMdd&dateEnd=yyyyMMdd
    router.attach("/reportcampaign/", ReportCampaignRest.class); //LIST All
    router.attach("/reportcampaign/{accountId}", ReportCampaignRest.class); //LIST Account level
    router.attach("/reportcampaign/campaign/{campaignId}", ReportCampaignRest.class); //LIST Campaign level

    // AdGroups
    // ?dateStart=yyyyMMdd&dateEnd=yyyyMMdd
    router.attach("/reportadgroup/", ReportAdGroupRest.class); //LIST All
    router.attach("/reportadgroup/{accountId}", ReportAdGroupRest.class); //LIST Account level
    router.attach("/reportadgroup/campaign/{campaignId}", ReportAdGroupRest.class); //LIST Campaign level
    router.attach("/reportadgroup/adgroup/{adGroupId}", ReportAdGroupRest.class); //LIST AdGroup level

    // Ads
    // ?dateStart=yyyyMMdd&dateEnd=yyyyMMdd
    router.attach("/reportad/", ReportAdRest.class); //LIST All
    router.attach("/reportad/{accountId}", ReportAdRest.class); //LIST Account level
    router.attach("/reportad/campaign/{campaignId}", ReportAdRest.class); //LIST Campaign level
    router.attach("/reportad/adgroup/{adGroupId}", ReportAdRest.class); //LIST AdGroup level
    router.attach("/reportad/ad/{adId}", ReportAdRest.class); //LIST Ad level

    // Keywords
    // ?dateStart=yyyyMMdd&dateEnd=yyyyMMdd
    router.attach("/reportkeyword/", ReportKeywordRest.class); //LIST All
    router.attach("/reportkeyword/{accountId}", ReportKeywordRest.class); //LIST Account level
    router.attach("/reportkeyword/campaign/{campaignId}", ReportKeywordRest.class); //LIST Campaign level
    router.attach("/reportkeyword/adgroup/{adGroupId}", ReportKeywordRest.class); //LIST AdGroup level
    router.attach("/reportkeyword/keyword/{criterionId}", ReportKeywordRest.class); //LIST Keyword level

    // ReportCampaignNegativeKeyword
    // This one does not support dateStart and dateEnd
    router.attach("/reportcampaignnegativekeyword/", ReportCampaignNegativeKeywordRest.class); //LIST All
    router.attach("/reportcampaignnegativekeyword/{accountId}", ReportCampaignNegativeKeywordRest.class); //LIST Account level
    router.attach("/reportcampaignnegativekeyword/campaign/{campaignId}", ReportCampaignNegativeKeywordRest.class); //LIST Campaign level
    router.attach("/reportcampaignnegativekeyword/keyword/{criterionId}", ReportCampaignNegativeKeywordRest.class); //LIST Keyword level

    // ReportAdExtension
    // ?dateStart=yyyyMMdd&dateEnd=yyyyMMdd
    router.attach("/reportadextension/", ReportAdExtensionRest.class); //LIST All
    router.attach("/reportadextension/{accountId}", ReportAdExtensionRest.class); //LIST Account level
    router.attach("/reportadextension/campaign/{campaignId}", ReportAdExtensionRest.class); //LIST Campaign level
    router.attach("/reportadextension/adextension/{adExtensionId}", ReportAdExtensionRest.class); //LIST Keyword level

    // *** Kratu ***
    // ?includeZeroImpressions=false by default
    router.attach("/kratu/", KratuRest.class); // List All
    router.attach("/kratu/{accountId}", KratuRest.class); // LIST Account level

    // Genereate Kratus MCC level
    // ?dateStart=yyyyMMdd&dateEnd=yyyyMMdd
    router.attach("/generatekratus/", GenerateKratusRest.class);

    // *** Static files *** 
    String target = "index.html";
    Redirector redirector = new Redirector(getContext(), target, Redirector.MODE_CLIENT_FOUND);
    router.attach("/", redirector);
    router.attach("", new Directory(getContext(), "clap://classloader/"));
    Client client = new Client(getContext(), Protocol.CLAP);
    getContext().setClientDispatcher(client);

    return router;
  }
}