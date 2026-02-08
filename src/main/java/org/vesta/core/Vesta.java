package org.vesta.core;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.config.factories.GenericFactory;
import org.vesta.bot.VestaBot;
import org.vesta.core.incidents.Incidents;
import org.vesta.core.incidents.Ban;

import java.io.File;

public class Vesta extends QuiptIntegration {

    public static final Vesta INSTANCE = new Vesta();
    public final VestaBot bot = new VestaBot(this);

    @Override
    public String name() {
        return "Vesta";
    }

    @Override
    public String version() {
        return "in-dev";
    }

    @Override
    public File folder() {
        return new File("data");
    }

    @Override
    public void enable() {
        configs().factory(new GenericFactory<>(Ban.class));
        configs().register(Incidents.class);
        bot.enable();
    }

    public VestaBot bot(){
        return bot;
    }
}
