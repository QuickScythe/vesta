package org.vesta.core.clients.reports;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.resources.ResourceManager;
import org.vesta.bot.plugin.events.ReportSubmitEvent;
import org.vesta.core.Vesta;

import java.io.File;
import java.util.function.Function;

public class ReportManager extends ResourceManager<URID, Report> {
    public ReportManager(QuiptIntegration integration, String name, File containerFolder, Function<Long, URID> resourceIdentifier, Class<Report> resourceClass) {
        super(integration, name, containerFolder, resourceIdentifier, resourceClass);
    }

    @Override
    public Report create(URID identifier) {
        Report report = super.create(identifier);
        if (report != null)
            Vesta.INSTANCE.bot().plugins().events().handle(new ReportSubmitEvent(Vesta.INSTANCE.bot(), report));
        return report;
    }

    @Override
    public URID from(File file, URID original){
        URID rid;
        String raw = file.getName();

        String[] parts = raw.substring(0, raw.indexOf(original.prefix())).split("-");
        if (parts.length > 1) {
            int i = Integer.parseInt(parts[1]);
            rid = date(original.date().getTime());
            rid.setIncrement(i);
        } else rid = original;
        return rid;
    }


}
