package com.librarysystem.core;

import com.librarysystem.Command;
import com.librarysystem.commands.LoginCommand;
import com.librarysystem.commands.StartCommand;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    String username, password;
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String x = update.getMessage().getText();
            String token = x.split("\\s")[0];
            Command command;
            switch (token) {
                case "/start":
                    command = new StartCommand(update.getMessage().getFrom(), update.getMessage().getChat());
                    SendMessage reply = command.run();
                    try {
                        execute(reply);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    break;
                case "/login":
                    command = new LoginCommand(update.getMessage().getFrom(), update.getMessage().getChat());
                    try {
                        execute(command.run());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "login":
                    String[] credentials = x.split("\\s");
                     username = credentials[1];
                     password = credentials[2];
                     boolean successful = true;
                     // try to login in
                    if(successful) {

                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

                        List<KeyboardRow> keyboard = new ArrayList<>();

                        KeyboardRow row = new KeyboardRow();
                        row.add("\uD83D\uDE80Checkout document");
                        keyboard.add(row);

                        row = new KeyboardRow();

                        row.add("\uD83D\uDD0ESearch");
                        keyboard.add(row);

                        row = new KeyboardRow();

                        row.add("⚙️Settings");

                        keyboard.add(row);

                        row = new KeyboardRow();

                        row.add("Logout");


                        keyboard.add(row);

                        keyboardMarkup.setKeyboard(keyboard);
                        SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText("Success!");

                        message.setReplyMarkup(keyboardMarkup);
                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            execute(new SendMessage().
                                    setChatId(update.getMessage().getChatId()).setText("Unsuccessful. Use /login to try again"));
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }

                    break;

                default:
                    switch (x) {
                        case "\uD83D\uDE80Checkout document":
                            ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove
                                    ();
                            SendMessage msg = new SendMessage().
                                    setText("Enter the name of the book you want to borrow")
                                    .setChatId(update.getMessage().getChatId());
                            msg.setReplyMarkup(keyboardMarkup);
                            try {
                                execute(msg);
                            }catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                    }

                    }


            }
        }

    @Override
    public String getBotUsername() {
        return "konyvtar_bot";
    }

    @Override
    public String getBotToken() {
        return "404457992:AAE0dHw07sHw8woSFiMJSebrQCK2aUyN8CM";
    }

}
