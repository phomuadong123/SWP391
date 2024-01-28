/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author tuant
 */
public class Slider {
    private int sid;
    private String title ;
    private String image;
    private String content;

    public Slider() {
        
    }

    public int getSid() {
        return sid;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
}
