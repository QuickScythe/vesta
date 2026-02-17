package org.vesta.core.clients.reports;

import com.quiptmc2.core.resources.ResourceIdentifier;
import org.vesta.core.clients.Client;

public class URID extends ResourceIdentifier {

    private final Client client;

    public URID(Client client, long date){
        super("RIN", date);
        this.client = client;
    }

    @Override
    public String toString() {
        return client.prefix() + "-" +super.toString();
    }
}