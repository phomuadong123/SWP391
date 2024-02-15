/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 *
 * @author toden
 */
public class Helper {

    public static String convertToBase64(InputStream inputStream) throws IOException {
        byte[] imageBytes = new byte[inputStream.available()];
        inputStream.read(imageBytes);
        inputStream.close();

        // Encode byte array to base64
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
