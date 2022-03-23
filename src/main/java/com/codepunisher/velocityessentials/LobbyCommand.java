package com.codepunisher.velocityessentials;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.Optional;

public class LobbyCommand implements SimpleCommand {
    private final ProxyServer server;

    public LobbyCommand(ProxyServer server) {
        this.server = server;
    }

    @Override
    public void execute(Invocation invocation) {
        CommandSource source = invocation.source();
        Optional<RegisteredServer> toConnect = server.getServer("hub");

        if (source instanceof Player player) {
            if (toConnect.isEmpty()) {
                player.sendMessage(Component.text("Error message test", NamedTextColor.RED));
                return;
            }

            player.createConnectionRequest(toConnect.get()).fireAndForget();
        }
    }
}
