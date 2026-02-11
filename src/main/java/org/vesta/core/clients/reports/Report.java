package org.vesta.core.clients.reports;


import com.quiptmc2.core.resources.Resource;
import com.quiptmc2.discord.plugins.events.custom.EventData;

import java.io.File;

public class Report extends Resource<URID> implements EventData {

    public long timestamp = System.currentTimeMillis();

    public Report(URID id, File managerFolder) {
        super(id, managerFolder);
    }
}
