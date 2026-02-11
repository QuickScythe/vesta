package org.vesta.core.clients.reports;

import com.quiptmc2.core.resources.ResourceIdentifier;

public class URID extends ResourceIdentifier {

    public URID(long date){
        super("RIN", date);
    }

}