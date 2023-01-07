package com.skypro.petbot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PetBotUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(PetBotUpdatesListener.class);

    private static final String START_COMMAND = "/start";
    private static final String HELLO_TEXT = "Привет! Этот телеграм-бот создан, чтобы помочь Вам обрести друга";

    private static final String HISTORY_SHELTER = "/about";

    private static final String HISTORY_ABOUT = "В нашем приюте потерявшиеся, выкинутые и брошенные собаки получают шанс и надежду обрести любящую семью и новый дом.";

    private static  final String GET_PET = "/getPet";

    private static final String GET_PET_TEXT = "Для того, чтобы приютить питомца необходимы следующие документы: паспорт, справка и подтверждение";

    private final TelegramBot telegramBot;


    public PetBotUpdatesListener(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);

            // Текст сообщения из чата
            String text = update.message().text();
            if(text != null){
                return ;
            }
            
            //ID чата
            Long chatId = update.message().chat().id();

            /**
             * Получаем стартовый текст сообщения из чата и отправляем ответ.
             * Используется метод sendMessage, описанный ниже.
             */
            Message message = update.message();
            if (message.text().equals(START_COMMAND)) {
                logger.info(START_COMMAND + "received");
                sendMessage(message.chat().id(), HELLO_TEXT);

            } else if (message.text().equals(HISTORY_SHELTER)) {
                logger.info(HISTORY_SHELTER + "received");
                sendMessage(message.chat().id(), HISTORY_ABOUT);

            } else if (message.text().equals(GET_PET)){
                logger.info(GET_PET + "received");
                sendMessage((message.chat().id()), GET_PET_TEXT);

            }

        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    /**
     * Отправляем сообщение пользователю.
     * @param chatId идентификатор сообщения в чате
     * @param message текст сообщения
     */
    private void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage(chatId, message);
        telegramBot.execute(sendMessage);
    }



}