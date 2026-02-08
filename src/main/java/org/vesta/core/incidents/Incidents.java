package org.vesta.core.incidents;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.config.Config;
import com.quiptmc2.core.config.ConfigTemplate;
import com.quiptmc2.core.config.ConfigValue;
import com.quiptmc2.core.config.objects.ConfigMap;

import java.io.File;

@ConfigTemplate(name = "incidents", ext = ConfigTemplate.Extension.JSON)
public class Incidents extends Config {

    @ConfigValue
    ConfigMap<Ban> bans;

    public Incidents(File file, String name, ConfigTemplate.Extension extension, QuiptIntegration integration) {
        super(file, name, extension, integration);
        bans = new ConfigMap<>(integration);
    }
}
