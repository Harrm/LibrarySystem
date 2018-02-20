package com.librarysystem;

import org.telegram.telegrambots.api.methods.send.SendMessage;

public interface Command {
    SendMessage run();
}
