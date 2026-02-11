package org.vesta.bot;

import com.quiptmc2.discord.Bot;
import org.vesta.bot.config.VestaConfig;
import org.vesta.core.Vesta;

import java.io.File;

public class VestaBot extends Bot {

    private final Vesta vesta;

    public VestaBot(Vesta vesta) {
        this.vesta = vesta;
    }

    @Override
    public void enable() {
        super.enable();
        VestaConfig config = configs().register(VestaConfig.class);
        System.out.println(config.time_punch_channel);
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
