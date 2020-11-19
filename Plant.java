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
    public Plant(String name, String sciName, String nickname, String light, String water, String mLevel) {
        plantName = name;
        plantSciName = sciName;
        plantNickname = nickname;
        plantLight = light;
        plantWaterInfo = water;
        maintenanceLevel = mLevel;
    }
    
    public void printInfo() {
        System.out.println("Name: " + plantName);
        System.out.println("SciName: " + plantSciName);
        System.out.println("Nickname: " + plantNickname);
        System.out.println("Light: " + plantLight);
        System.out.println("Water: " + plantWaterInfo);
        System.out.println("Maintenance Level: " + maintenanceLevel);
    }
    
    private String plantName;
    private String plantSciName;
    private String plantNickname;
    private String plantLight;
    private String plantWaterInfo;
    private Date lastWatered;
    private String maintenanceLevel;
}

