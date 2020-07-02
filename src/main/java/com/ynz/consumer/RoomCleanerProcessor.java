package com.ynz.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class RoomCleanerProcessor {

    private final ObjectMapper objectMapper;

    @Autowired
    public RoomCleanerProcessor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void receiveMessage(String roomJson) {
        log.info("Message received");

        try {
            Room room = objectMapper.readValue(roomJson, Room.class);

            log.info("Room ready for cleaning " + room.getNumber());

        } catch (IOException e) {
            log.error("error: ", e);
        }
    }


}
