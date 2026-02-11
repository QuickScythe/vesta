package org.vesta.core.clients;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.data.registries.Registry;
public class Clients extends Registry<Client> {

    public Clients(QuiptIntegration integration, String key) {
        super(integration.registries().key(key));
    }
}
