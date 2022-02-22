package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;

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
  public void bookSlots(int slots) throws NotEnoughFreeSlotsException {

    if(freeSlots() < slots){
      throw new NotEnoughFreeSlotsException(slots, freeSlots());
    }

    bookedRoomCount = bookedRoomCount + slots;
  }

  @Override
  public int freeSlots(){
    return roomCount - bookedRoomCount;
  }



}
