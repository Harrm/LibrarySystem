package com.librarysystem.core;

import com.librarysystem.Command;
import com.librarysystem.commands.LoginCommand;
import com.librarysystem.commands.StartCommand;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bot extends TelegramLongPollingBot {

    String username, password;
    // entry point of bot
    @Override
    public void onUpdateReceived(Update update) {
        Scanner scanner = null;
        PrintWriter writer = null;
        try {
            scanner = new Scanner(new File("C:\\Users\\Gfred\\Downloads\\Compressed\\LibrarySystem\\input.txt"));
           writer = new PrintWriter(new FileWriter("C:\\Users\\Gfred\\Downloads\\Compressed\\LibrarySystem\\input.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (update.hasMessage() && update.getMessage().hasText()) {
            String x = update.getMessage().getText();
            Command command;
            switch (x) {
                case "/start":
                    command = new StartCommand(update.getMessage().getFrom(), update.getMessage().getChat());


                    SendMessage reply = command.run();
                    ReplyKeyboardRemove removeKeyboardMarkup = new ReplyKeyboardRemove(); // hides keyboard in case it's showing already
                    reply.setReplyMarkup(removeKeyboardMarkup);
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
                        documentUserLastCommand(update, writer);
                    } catch (TelegramApiException ex) {
                        ex.printStackTrace();
                    }
                    break;

                default:
                    String previous = checkLastCommandFromUser(update.getMessage().getFrom(), scanner).trim();
                    System.out.println(previous);
                    if (previous.equals("/login")) {
                        username = update.getMessage().getText();
                        SendMessage usernameLogin = new SendMessage();
                        usernameLogin.setChatId(update.getMessage().getChatId());
                        usernameLogin.setText("Enter password");
                        try {
                            execute(usernameLogin);
                            documentUserInput(update, writer, "/username");
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else if(previous.equals("/username")) {
                        password = update.getMessage().getText();
                        if (username.equals("admin") && password.equals("root")) {
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
                                documentUserInput(update, writer, "/menu");
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

                      } else {
                        switch (update.getMessage().getText()) {
                            case "\uD83D\uDE80Checkout document":

                                if (previous.equals("/menu")) {
                                    SendMessage msg = new SendMessage().setChatId(update.getMessage().getChatId())
                                            .setText("Enter the name of the document you want to check out");
                                    try {
                                        documentUserInput(update, writer, "/checkout");
                                        execute(msg);
                                    } catch(TelegramApiException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    SendMessage msg = new SendMessage()
                                            .setChatId(update.getMessage().getChatId())
                                            .setText("Please /login or /signup first before you can execute this command.");
                                    try {
                                        execute(msg);
                                    } catch (TelegramApiException e) {
                                        e.printStackTrace();
                                    }
                                }

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

    String checkLastCommandFromUser(User user, Scanner scanner) {
        String command = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(user.getId().toString())) {
                command = line.substring(line.lastIndexOf('/'));
            }
        }
        if (command == null) {
            return null;
        } else return command;
    }

    void documentUserLastCommand(Update update, PrintWriter writer) {


            String message = update.getMessage().getText();
            User u = update.getMessage().getFrom();
            writer.append(u.getId().toString());
            writer.append(message);
            writer.append("\n");
            writer.close();



    }

    void documentUserInput(Update update, PrintWriter writer, String message) {
       User u = update.getMessage().getFrom();
       writer.append(u.getId().toString());
       writer.append(message);
       writer.append("\n");
       writer.close();
    }

}
