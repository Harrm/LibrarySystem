package org.user_interface.ui;

import org.items.User;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class KeyboardUtils {


    private static AbsSender sender = new Bot();
    Long chatId;


    public void showMainMenuKeyboard(Long chatId, User user, String msg) {
        this.chatId = chatId;
        showMainMenuKeyboard(user, msg);
    }
    public void showMainMenuKeyboard(User user, String msg) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        if(!user.getType().equals("Librarian")) {
            row.add("Checkout");
            row.add("Return");
            row.add("Renew");
            keyboard.add(row);
        }

        if(user.getType().equals("Librarian")) {
            row = new KeyboardRow();
            row.add("Edit");
            row.add("Add");
            row.add("Fine");
            row.add("Outstanding Request");
            keyboard.add(row);
        }

        row = new KeyboardRow();
        row.add("Search");
        //row.add("️Settings");
        row.add("Logout");
        keyboard.add(row);

        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setKeyboard(keyboard);

        SendMessage message = new SendMessage().setChatId(chatId).setText(msg);
        message.setReplyMarkup(keyboardMarkup);
        message.enableMarkdown(true);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void setInlineKeyBoard(String message, List<String> commands) {

        SendMessage msg = new SendMessage();

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        for(String i: commands) {
            row.add(new InlineKeyboardButton().
                    setText(i).setCallbackData(i.trim()));
            rows.add(row);
            row = new ArrayList<>();
        }

        msg.setChatId(chatId);
        msg.setText(message);

        markup.setKeyboard(rows);
        msg.setReplyMarkup(markup);

        try {
            sender.execute(msg);
        }catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public   void showCRUDkeyboard(String type) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(type + " Document");
        row.add(type + " User");
        keyboard.add(row);

        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setKeyboard(keyboard);

        SendMessage message = new SendMessage().setChatId(chatId).setText("Choose an option");
        message.setReplyMarkup(keyboardMarkup);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


    public void showEditDocumentKeyboard() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyb = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Book");
        row.add("AV Material");
        keyb.add(row);

        row = new KeyboardRow();
        row.add("Journal Article");
        row.add("Journal Issue");
        keyb.add(row);

        markup.setResizeKeyboard(true);
        markup.setKeyboard(keyb);

        SendMessage message = new SendMessage().setChatId(chatId).setText("Choose an option");
        message.setReplyMarkup(markup);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public KeyboardUtils(Update update) {
        this.chatId = update.hasMessage() ? update.getMessage().getChatId()
                : update.getCallbackQuery().getMessage().getChatId();
    }
}
