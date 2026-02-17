package org.vesta.core;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.core.config.factories.GenericFactory;
import com.quiptmc2.core.resources.Resource;
import com.quiptmc2.discord.plugins.BotPlugin;
import org.vesta.bot.VestaBot;
import org.vesta.bot.plugin.VestaPlugin;
import org.vesta.core.clients.Client;
import org.vesta.core.clients.ClientFactory;
import org.vesta.core.clients.Clients;
import org.vesta.core.clients.reports.Report;
import org.vesta.core.clients.reports.URID;
import org.vesta.core.incidents.Ban;
import org.vesta.core.incidents.Incidents;

import java.io.File;

public class Vesta extends QuiptIntegration {

    public static final Vesta INSTANCE = new Vesta();
    public final VestaBot bot = new VestaBot(this);

    private Clients clients;

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

    public Clients clients() {
        return clients;
    }

    @Override
    public void enable() {


        configs().factory(new ClientFactory());
        clients=configs().register(Clients.class);
        bot.enable();
        BotPlugin plugin = bot().plugins().register(VestaPlugin.class);
        bot().plugins().enable(plugin);



        logger().log("VestaBot", "VestaBot enabled.");
    }

    public VestaBot bot() {
        return bot;
    }
}
