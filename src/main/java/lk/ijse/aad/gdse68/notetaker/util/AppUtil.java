package lk.ijse.aad.gdse68.notetaker.util;



import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;
public class AppUtil {

    public  static String createNoteId(){
        return UUID.randomUUID().toString();
    }
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
    public static String createUserId(){
    return "User"+ UUID.randomUUID().toString();
    }
//    encode-
//    decode-
    public static String toBase64Profilepic(String profilepic){
        return Base64.getEncoder().encodeToString(profilepic.getBytes());
    }
}
