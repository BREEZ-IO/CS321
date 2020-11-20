import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amberlaihipp
 */
public class Plant {
    public Plant(String name, String sciName, String nickname, String light, String water, String lastWatered, String mLevel) {
        plantName = name;
        plantSciName = sciName;
        plantNickname = nickname;
        plantLight = light;
        plantWaterInfo = water;
        lastWatered = lastWatered;
        maintenanceLevel = mLevel;
    }
    
    public String getName() {
        return plantName;
    }
    
    public String getSciName() {
        return plantSciName;
    }
    
    public String getNickname() {
        return plantNickname;
    }
    
    public void setNickname(String nickname) {
        this.plantNickname = nickname;
    }
    
    public String getLightInfo() {
        return plantLight;
    }
    
    public String getWaterInfo() {
        return plantWaterInfo;
    }
    
    public String getLastWaterDate() {
       return lastWatered;
    }
    
    //public void setLastWaterDate(Date d) {
    //    
    //}
    
    public String getMaintenanceLevel() {
        return maintenanceLevel;
    }
    
    public void printInfo() {
        System.out.println("Name: " + plantName);
        System.out.println("Scientific Name: " + plantSciName);
        System.out.println("Nickname: " + plantNickname);
        System.out.println("Light: " + plantLight);
        System.out.println("Water: " + plantWaterInfo);
        System.out.println("Last Watered: " + lastWatered);
        System.out.println("Maintenance Level: " + maintenanceLevel);
    }
    
    private String plantName;
    private String plantSciName;
    private String plantNickname;
    private String plantLight;
    private String plantWaterInfo;
    private String lastWatered;
    private String maintenanceLevel;
}

