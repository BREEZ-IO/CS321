import java.util.Date;

/**
 * Plant class used to represent an individual plant
 *
 * @author Amber Lai Hipp
 */
public class Plant {
        /**
     * Plant constructor used to make an instance of the Plant class
     * @param plantName: The plant's common name
     * @param plantSciName: The plant's scientific name
     * @param plantNickname: The plant's nickname given by the user
     * @param plantLight: The light level required by the plant
     * @param plantWaterInfo: The watering period of the plant
     * @param lastWatered: The last date that the plant was watered
     * @param maintenanceLevel: How difficult the plant is to keep alive
     */
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
    
    public void setLastWateredDate() {
        LocalDate date = LocalDate.now();
        lastWatered = date.toString();
    }
    
    public String getMaintenanceLevel() {
        return maintenanceLevel;
    }
    
    private int getWaterInfoinDays(){
        if (plantWaterInfo.contains("Once a week")){
            return 7;
        }
        else if (plantWaterInfo.contains("Twice a week")){
            return 3;
        }
        else if (plantWaterInfo.contains("Twice a month")){
            return 14;
        }
        else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return String.format("Name: " + plantName + "\nScientific Name: " + plantSciName
                + "\nNickname: " + plantNickname + "\nLight: " + plantLight + "\nWater: " +
                plantWaterInfo + "\nLast Watered: " + lastWatered + "\nMaintenance Level: "
                + maintenanceLevel + "\n\n");
    }
    
    private String plantName;
    private String plantSciName;
    private String plantNickname;
    private String plantLight;
    private String plantWaterInfo;
    private String lastWatered;
    private String maintenanceLevel;
}
