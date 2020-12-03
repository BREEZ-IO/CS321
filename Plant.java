import java.util.Date;

/**
 * Plant class used to represent an individual plant
 * @param plantName: The plant's common name
 * @param plantSciName: The plant's scientific name
 * @param plantNickname: The plant's nickname given by the user
 * @param plantLight: The light level required by the plant
 * @param plantWaterInfo: The watering period of the plant
 * @param lastWatered: The last date that the plant was watered
 * @param maintenanceLevel: How difficult the plant is to keep alive

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
    /**
    Function to get the plant's name
    @return plantName: everyday name of plant
    */
    public String getName() {
        return plantName;
    }
    /**
    Function to get the plant's scientific name.
    @return plantSciName: the plant's scientific name
    */
    public String getSciName() {
        return plantSciName;
    }
    
    /**
    Function to get the plant's nickname.
    @return plantNickName: the plant's nickname
    */
    public String getNickname() {
        return plantNickname;
    }
    /**
    Function to set the plant's nickname.
    @param nickname: the plant's new nickname.
    */  
    public void setNickname(String nickname) {
        this.plantNickname = nickname;
    }
    /**
    Function to get the plant's light-level needs.
    @return plantLight: The light level the plant needs-low, indirect, bright
    */
    public String getLightInfo() {
        return plantLight;
    }
    /**
    Function to get the plant's watering schedule.
    @return getWaterInfo: the plant's watering schedule in human-understandable format.
    */
    public String getWaterInfo() {
        return plantWaterInfo;
    }
    /**
    Function to get the last date that the plant was watered.
    @return lastWatered: the LocalDate that the plant was watered last
    */
    public String getLastWaterDate() {
       return lastWatered;
    }
    /**
    Function to get the plant's nickname.
    @return plantNickName: the plant's nickname
    */
    public void setLastWateredDate() {
        LocalDate date = LocalDate.now();
        lastWatered = date.toString();
    }
    /**
    Function to get the plant's care difficulty.
    @return maintenanceLevel: How easy the plant is to take care of
    */
    public String getMaintenanceLevel() {
        return maintenanceLevel;
    }
    /**
    Function to get the number of days between waterings in integer form.
    @return int
    */
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
    /**
    Formats the plant's information and returns it as a readable string.
    */
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
