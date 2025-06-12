package org.macver.linty.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.md_5.bungee.api.chat.TextComponent;
import org.macver.linty.data.types.Command;
import org.macver.linty.data.types.ui.Content;
import org.macver.linty.data.types.ui.LineBreak;
import org.macver.linty.data.types.ui.frame.SimpleFrame;
import org.macver.linty.data.types.ui.frame.TabbedFrame;
import org.macver.linty.data.types.ui.interactive.Button;
import org.macver.linty.data.types.ui.interactive.Tab;

public class CommandLinty implements Command {
    @Override
    public CommandAPICommand getCommand() {
        return new CommandAPICommand("linty")
                .executes((sender, args) -> {
                    sender.spigot().sendMessage(new TabbedFrame("Test Frame",
                            new Tab("Tab 1")
                                    .setContents(
                                            new Content(new TextComponent("Hello, world!")),
                                            new LineBreak(),
                                            new Content(new TextComponent("Here is a button.")),
                                            new Button("Button"),
                                            new SimpleFrame("Another frame")
                                                    .setButtons(
                                                            new Button("Frame button")
                                                    )
                                                    .setElements(
                                                            new Content(new TextComponent("Hello again."))
                                                    )
                                    ),
                            new Tab("Tab 2")
                    )
                            .render(0));
                });
    }
}
