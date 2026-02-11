package org.vesta.core.clients;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.resources.ResourceManager;
import org.vesta.bot.plugin.events.ReportSubmitEvent;
import org.vesta.core.Vesta;
import org.vesta.core.clients.reports.Report;
import org.vesta.core.clients.reports.URID;

import java.io.File;

public class Client extends ResourceManager<URID, Report> {

    public Client(QuiptIntegration integration, String name) {
        super(integration, name, URID::new);
    }

    @Override
    public File folder() {
        File folder = new File(integration.folder(), "clients/" +name);
        if(!folder.exists()){
            integration.logger().log("ResourceManager", "Creating resource manager: " + (folder.mkdirs() ? "success" : "failed"));
        }
        return folder;
    }



    @Override
    public Report create(URID identifier) {
        Report report = super.create(identifier);
        Vesta.INSTANCE.bot().plugins().events().handle(new ReportSubmitEvent(Vesta.INSTANCE.bot(), report));
        return report;
    }
}
