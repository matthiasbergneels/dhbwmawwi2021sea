package lecture.chapter11;

import java.io.File;

public class FileSystemAccess {

  public static void main(String[] args) {

    File[] drives = File.listRoots();

    for(File drive : drives){
      System.out.println(drive.getPath() + " existiert: " + drive.exists());
    }

  }
}
