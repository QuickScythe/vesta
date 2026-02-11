package org.vesta.bot.plugin;

import com.quiptmc2.discord.plugins.BotPlugin;
import com.quiptmc2.discord.plugins.BotPluginLoader;
import org.vesta.bot.plugin.listeners.ReportSubmitListener;
import org.vesta.bot.plugin.listeners.TimePunchListener;

import java.io.File;

public class VestaPlugin extends BotPlugin {

    public VestaPlugin(BotPluginLoader pluginLoader) {
        super(pluginLoader);
    }

    @Override
    public String version() {
        return "in-dev";
    }

    @Override
    public File folder() {
        return new File(bot().folder(), "extra");
    }

    public void enable(){
        bot().plugins().events().register("time-punch", new TimePunchListener());
        bot().plugins().events().register("report-submit", new ReportSubmitListener());
    }

    @Override
    public String name() {
        return "VestaPlugin";
    }

    @Override
    public void disable() {

    }
}
