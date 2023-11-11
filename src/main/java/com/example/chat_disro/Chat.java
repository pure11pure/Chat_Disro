package com.example.chat_disro;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data // สร้างต่าง ๆ อัตโนมัติเช่น getter, setter, toString, hashCode, และ equals เพื่อลดจำนวนโค้ดที่ต้องเขียนเอง
@Document("Disro_db") //Mongo collection
public class Chat implements Serializable {
    @Id
    private String _id; // ใช้เป็น ObjectId ของ MongoDB
    private String roomId; // รหัสห้องแชท
    private Object user; //ผู้ใช้ที่ส่งข้อความ
    private String text; // ข้อความแชท
    private Date dateTime; // วันที่และเวลา

    // Constructor สำหรับคลาส Chat
    public Chat(String roomId, Object user,String text, Date dateTime) {
        this.roomId = roomId;
        this.user = user;
        this.text = text;
        this.dateTime = dateTime;
    }
}
