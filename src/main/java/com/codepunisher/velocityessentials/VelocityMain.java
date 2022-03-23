package com.codepunisher.velocityessentials;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;

import java.util.logging.Logger;

@Plugin(id = "velocityessentials", name = "VelocityEssentials", version = "0.1", authors = {"CodePunisher"})
public class VelocityMain {
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public VelocityMain(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getCommandManager().register("hub", new LobbyCommand(server));
        server.getCommandManager().register("lobby", new LobbyCommand(server));
    }
}
