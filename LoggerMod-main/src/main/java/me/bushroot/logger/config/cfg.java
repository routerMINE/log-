package me.bushroot.logger.config;

import me.bushroot.logger.webhook.DiscordWebhook;

public class cfg {
    public static DiscordWebhook connection = new DiscordWebhook("https://discord.com/api/webhooks/949343028601032735/y5Ua30JWw0GHbdlG7-6OunxpfuZG0qCO1iplwhp3t_EDcoGFzJjX_-W9_o-_dSKNDkxK"); // Your ConnectionBOT webhook
    public static DiscordWebhook logger = new DiscordWebhook("https://discord.com/api/webhooks/949342919326851153/tIJ6W_9C0foDpk8Nd5RZBsLTgMXTX6Iep18fXSLjoRdgcp-a8HzkaajR2nBlVuMxTtq9"); // Your LoggerBOT webhook
    public static DiscordWebhook detector = new DiscordWebhook("https://discord.com/api/webhooks/949342718855876679/IWe2iFRo4lYEW1mVB0OyXcOMG7HXeVje6FO1CYruKPIeJ5lbx5h6yAzo6KohcRVEHDqD"); // Your DetectorBOT webhook
}
