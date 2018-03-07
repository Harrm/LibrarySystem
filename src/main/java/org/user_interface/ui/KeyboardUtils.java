package org.user_interface.ui;

import org.resources.User;
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
    public void showMainMenuKeyboard(AbsSender sender, Update update, User user, String msg) {
        Long chatId;
        if(update.hasMessage()) {
         chatId = update.getMessage().getChatId();
        } else {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        }


        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Checkout Document");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Return Document");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Search");
        keyboard.add(row);

        if(user.getType().equals("Librarian")) {
            row = new KeyboardRow();
            row.add("Edit");
            keyboard.add(row);
        }


        row = new KeyboardRow();
        row.add("️Settings");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Logout");
        keyboard.add(row);


        keyboardMarkup.setKeyboard(keyboard);

        SendMessage message = new SendMessage().setChatId(chatId).setText(msg);
        message.setReplyMarkup(keyboardMarkup);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

   public void setInlineKeyBoard(AbsSender sender, Update update, String message, List<String> commands) {
        Long chatId = 0L;
       if(update.hasCallbackQuery()) {
           chatId = update.getCallbackQuery().getMessage().getChatId();
       } else if(update.hasMessage()) {
           chatId = update.getMessage().getChatId();
       }
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

  public   void showCRUDkeyboard(AbsSender sender, Update update) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Add Document");
        row.add("Edit Document");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Add User");
        row.add("Edit User");
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);

        SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText("Choose an option");
        message.setReplyMarkup(keyboardMarkup);
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
