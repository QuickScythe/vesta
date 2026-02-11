package org.vesta.bot.plugin.events;

import com.quiptmc2.core.QuiptIntegration;
import com.quiptmc2.discord.Bot;
import com.quiptmc2.discord.api.guild.channel.QuiptTextChannel;
import com.quiptmc2.discord.plugins.events.custom.CustomEvent;
import org.vesta.core.clients.reports.Report;

public class ReportSubmitEvent extends CustomEvent<Report> {

    Bot integration;

    public ReportSubmitEvent(Bot integration, Report data) {
        super(data);
        this.integration = integration;
    }

    public QuiptTextChannel channel() {
        return null;
    }
}
