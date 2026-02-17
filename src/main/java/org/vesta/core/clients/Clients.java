package org.vesta.core.clients;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.config.Config;
import com.quiptmc2.core.config.ConfigTemplate;
import com.quiptmc2.core.config.ConfigValue;
import com.quiptmc2.core.config.objects.ConfigMap;
import com.quiptmc2.core.config.objects.ConfigObject;
import com.quiptmc2.core.data.registries.Registry;

import java.io.File;

@ConfigTemplate(name = "clients", ext = ConfigTemplate.Extension.JSON)
public class Clients extends Config {

    @ConfigValue
    public ConfigMap<Client> clients;

    public Clients(File file, String name, ConfigTemplate.Extension extension, QuiptIntegration integration) {
        super(file, name, extension, integration);
        clients = new ConfigMap<>(integration);
    }

    public Client get(String name) {
        return clients.get(name);
    }

    public void register(Client client) {
        clients.put(client);
    }
}
