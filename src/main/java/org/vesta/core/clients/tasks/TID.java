package org.vesta.core.clients.tasks;

import com.quiptmc2.core.resources.ResourceIdentifier;

public class TID extends ResourceIdentifier {

    public TID(long date) {
        super("TID", date);
    }
}
