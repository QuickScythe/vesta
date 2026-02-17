package org.vesta.core.clients.tasks;

import com.quiptmc2.core.resources.Resource;
import org.json.JSONObject;

import java.io.File;

public class Task extends Resource<TID> {


    public Task(TID id, File managerFolder) {
        super(id, managerFolder);
    }
}
