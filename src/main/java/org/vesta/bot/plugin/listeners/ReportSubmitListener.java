package org.vesta.bot.plugin.listeners;

import com.quiptmc2.discord.api.guild.QuiptGuild;
import com.quiptmc2.discord.api.guild.channel.QuiptTextChannel;
import com.quiptmc2.discord.plugins.events.EventListener;
import org.vesta.bot.config.VestaConfig;
import org.vesta.bot.plugin.events.ReportSubmitEvent;
import org.vesta.core.Vesta;

public class ReportSubmitListener extends EventListener<ReportSubmitEvent> {

    public ReportSubmitListener() {
        super(ReportSubmitEvent.class);
    }

    @Override
    public void handle(ReportSubmitEvent event) {

        System.out.println(event.data());
        VestaConfig config = Vesta.INSTANCE.bot().configs().config(VestaConfig.class);
        for(QuiptGuild guild : Vesta.INSTANCE.bot().qda().guilds().all()){
            for(QuiptTextChannel channel : guild.getTextChannels()){
                if(channel.id().equals(config.time_punch_channel)){
                    channel.send("new report submitted: " + event.data());
                }
            }
        }
    }
}
