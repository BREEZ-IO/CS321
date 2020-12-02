import java.util.TimerTask;
import java.util.Timer;
import java.time.LocalDate;
class Reminder {
    Timer timer;
    public Reminder (int days, Plant plant, PlantList list){
        timer = new Timer();
        timer.schedule(new PlantReminder(plant, list), days * 86400000);
    }

    class PlantReminder extends TimerTask{
        private Plant temp;
        private PlantList newList;
        public PlantReminder(Plant plant, PlantList list){
            LocalDate date = LocalDate.now();
            temp=plant;
            newList=list;
            plant.setLastWaterDate(date);
        }
        public void run(){
            if(newList.SearchList(temp.getNickname(), "Nickname")!=null){
                System.out.println("Time to water your " + temp.getName() + " " + temp.getNickname());
                }
            else
                timer.cancel();
        }
    }
}
   