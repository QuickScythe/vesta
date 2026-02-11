package org.vesta.core.clients;


import com.quiptmc2.core.resources.ResourceIdentifier;

public class ClientIdentifier extends ResourceIdentifier {
    public ClientIdentifier(long date) {
        super("CLI", date);
    }
}
