package com.example.chat_disro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/chats")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @PostMapping
    public ResponseEntity<?> addChat(@RequestBody Chat chat) {
        System.out.println(chat);
        if (chat.getText() != null && !chat.getText().isEmpty()) {
            // สร้าง timestamp โดยอัตโนมัติที่เป็นปัจจุบัน
            chat.setDateTime(new Date()); // หรือ LocalDateTime.now() ถ้าคุณใช้ Java 8 หรือใหม่กว่า

            Chat addedChat = chatService.addChat(chat); // เพิ่มข้อมูลแชทโดยใช้คำขอ POST
            return new ResponseEntity<>(addedChat, HttpStatus.OK);
        } else {
            // หาก msg เป็นค่าว่างหรือ null ให้ส่งคำตอบผิดพลาดและแจ้งเตือนผู้ใช้
            String responseMessage = "ข้อมูลไม่ถูกต้องหรือไม่ครบถ้วน";
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/room/{roomId}")
    public List<Chat> getChatsByRoom(@PathVariable String roomId) {
        System.out.println("/room/"+roomId);
        return chatService.getChatsByRoom(roomId);
    }
}