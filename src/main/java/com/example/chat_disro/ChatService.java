package com.example.chat_disro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;
    public List<Chat> getAllChats() {
        return chatRepository.findAll(); // ใช้ chatRepository เพื่อดึงข้อมูลทั้งหมดจากฐานข้อมูล
    }

    public Chat addChat(Chat chat) {
        return chatRepository.save(chat); // เพิ่มข้อมูลแชทลงใน MongoDB
    }

    public List<Chat> getChatsByRoom(String roomId) {
        List<Chat> byRoomId = chatRepository.findByRoomId(roomId);
        System.out.println("getChatsByRoom"+byRoomId);
        return byRoomId;
    }
}

