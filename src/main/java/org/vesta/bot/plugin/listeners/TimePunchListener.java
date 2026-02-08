package org.vesta.bot.plugin.listeners;

import com.quiptmc2.core.discord.embed.Embed;
import com.quiptmc2.discord.plugins.events.Event;
import com.quiptmc2.discord.plugins.events.EventListener;
import com.quiptmc2.discord.plugins.events.message.MessageReceivedEvent;
import org.vesta.bot.config.VestaConfig;
import org.vesta.core.Vesta;

import java.awt.*;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimePunchListener extends EventListener.MessageReceivedListener {

    Map<String, Long> punches = new HashMap<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
//        if (!e.channel().id().equals(Vesta.INSTANCE.configs().config(VestaConfig.class).time_punch_channel) || e.author().bot())
//            return;
        if (e.author().bot()) return;
        String lowerCaseMessage = e.message().toString().toLowerCase();
        if (lowerCaseMessage.equals("in") || lowerCaseMessage.equals("out")) {
            Embed.Builder embedBuilder = new Embed.Builder()
                    .title("Time Punch Successful")
                    .color(new Color(0x4EC64E))
                    .author(e.author().original().getEffectiveName(), null, e.author().original().getEffectiveAvatarUrl());
            if (lowerCaseMessage.equals("in")) {
                if (punches.containsKey(e.author().id())) {
                    e.channel().send(e.author().mention() + " You have already punched in today");
                    return;
                }
                punches.put(e.author().id(), e.message().created().toInstant().toEpochMilli());
                embedBuilder.description(e.author().original().getEffectiveName() + " punched in.");
            } else {
                if (!punches.containsKey(e.author().id())) {
                    e.channel().send(e.author().mention() + " You have not punched in today");
                    return;
                }
                embedBuilder.description(e.author().name() + " punched out.")
                        .field("Hours worked", String.format("%.2f", (e.message().created().toInstant().toEpochMilli() - punches.get(e.author().id())) / 3600000.0), true);
                punches.remove(e.author().id());
            }
            embedBuilder.timestamp(new Date(e.message().created().toInstant().toEpochMilli()));

            e.channel().send(embedBuilder.build());
        } else {
            e.channel().send(e.author().mention() + " Please use `in` or `out` to punch time");
        }
    }
}
