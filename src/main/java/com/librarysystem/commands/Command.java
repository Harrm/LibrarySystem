package com.librarysystem.commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;

public interface Command {
    SendMessage run();
}
