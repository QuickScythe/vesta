package org.vesta.bot.config;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.config.Config;
import com.quiptmc2.core.config.ConfigTemplate;
import com.quiptmc2.core.config.ConfigValue;

import java.io.File;

@ConfigTemplate(name = "vesta", ext = ConfigTemplate.Extension.JSON)
public class VestaConfig extends Config {

    @ConfigValue
    public String bans_channel = "channel_id_here";

    @ConfigValue
    public String time_punch_channel = "channel_id_here";

    public VestaConfig(File file, String name, ConfigTemplate.Extension extension, QuiptIntegration integration) {
        super(file, name, extension, integration);
    }
}
