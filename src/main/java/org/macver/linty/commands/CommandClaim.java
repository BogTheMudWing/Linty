package org.macver.linty.commands;

import dev.jorel.commandapi.CommandAPICommand;
import org.macver.linty.data.types.Command;

public class CommandClaim implements Command {

    @Override
    public CommandAPICommand getCommand() {
        return new CommandAPICommand("claim")
                .withHelp("Create a claim.", "Create a claim to protect an area.")
                .executes((sender, args) -> {

                });
    }
}
