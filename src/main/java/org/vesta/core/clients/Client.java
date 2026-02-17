package org.vesta.core.clients;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.config.objects.ConfigObject;
import com.quiptmc2.core.resources.Resource;
import com.quiptmc2.core.resources.ResourceIdentifier;
import com.quiptmc2.core.resources.ResourceManager;
import org.json.JSONObject;
import org.vesta.bot.plugin.events.ReportSubmitEvent;
import org.vesta.core.Vesta;
import org.vesta.core.clients.reports.Report;
import org.vesta.core.clients.reports.ReportManager;
import org.vesta.core.clients.reports.URID;
import org.vesta.core.clients.tasks.TID;
import org.vesta.core.clients.tasks.Task;

import java.io.File;

public class Client extends ConfigObject {

    private final String name;

    private final ReportManager reports;
    private final ResourceManager<TID, Task> tasks;

    public Client(QuiptIntegration integration, String name, String prefix) {
        super(integration);
        this.name = name;
        super.id = prefix;
        reports = new ReportManager(integration, "reports", new File(integration.folder(), "clients/" + name + "/reports"), (time) -> new URID(this, time), Report.class);
        tasks = new ResourceManager<>(integration, "tasks", new File(integration.folder(), "clients/" + name + "/tasks"), TID::new, Task.class);
//        super(integration, name, new File(integration.folder(), "clients/" + name), URID::new);
    }

    public ReportManager reports() {
        return reports;
    }

    public ResourceManager<TID, Task> tasks() {
        return tasks;
    }

    public String name() {
        return name;
    }


    public String prefix() {
        return id();
    }

    @Override
    public JSONObject json() {
        return super.json().put("name", name);
    }
}
