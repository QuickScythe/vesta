package org.vesta.core.clients;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.config.objects.ConfigObject;
import org.json.JSONObject;

public class ClientFactory implements ConfigObject.Factory<Client> {
    @Override
    public String getClassName() {
        return Client.class.getName();
    }

    @Override
    public Client createFromJson(QuiptIntegration integration, JSONObject json) {
        if(!json.has("name") || !json.has("id"))
            return null;
        String name = json.getString("name");
        String prefix = json.getString("id");
        return new Client(integration, name, prefix);
    }
}
