package org.vesta.bot;

import com.quiptmc2.discord.Bot;
import com.quiptmc2.discord.plugins.BotPlugin;
import org.vesta.bot.config.VestaConfig;
import org.vesta.bot.plugin.VestaPlugin;
import org.vesta.core.Vesta;

import java.io.File;

public class VestaBot extends Bot {

    private final Vesta vesta;

    public VestaBot(Vesta vesta) {
        this.vesta = vesta;
    }

    @Override
    public void enable(){
        super.enable();
        configs().register(VestaConfig.class);
        BotPlugin plugin = plugins().register(VestaPlugin.class);
        plugins().enable(plugin);
        logger().log("VestaBot", "VestaBot enabled.");
    }

    @Override
    public File folder() {
        return new File(vesta.folder(), "bot");
    }

    @Override
    public String name() {
        return "VestaBot";
    }
}
