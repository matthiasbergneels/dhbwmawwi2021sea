package lecture.chapter7;

public class Hotel implements Bookable{

  private final int roomCount;
  private int bookedRoomCount;

  public Hotel(int roomCount){
    this.roomCount = roomCount;
    this.bookedRoomCount = 0;
  }

  public void clean(){
    System.out.println("und ich wisch, wisch, wisch...");
  }

  @Override
  public boolean bookSlots(int slots){

    if(freeSlots() >= slots){
      bookedRoomCount = bookedRoomCount + slots;
      return true;
    }

    return false;
  }

  @Override
  public int freeSlots(){
    return roomCount - bookedRoomCount;
  }



}
