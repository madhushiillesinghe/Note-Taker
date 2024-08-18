package lk.ijse.aad.gdse68.notetaker.util;

import java.util.UUID;

public class AppUtil {
    public  static String createNoteId(){
        return UUID.randomUUID().toString();
    }
}
