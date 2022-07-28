package com.skypro.petbot.scheduler;

import com.pengrad.telegrambot.TelegramBot;
import com.skypro.petbot.listener.PetBotUpdatesListener;
import com.skypro.petbot.repository.NotificationTaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationTaskScheduler {
    private Logger logger = LoggerFactory.getLogger(PetBotUpdatesListener.class);

    private final NotificationTaskRepository repository;
    private final TelegramBot telegramBot;

    @Autowired
    public NotificationTaskScheduler(NotificationTaskRepository repository, TelegramBot telegramBot) {
        this.repository = repository;
        this.telegramBot = telegramBot;
    }

}