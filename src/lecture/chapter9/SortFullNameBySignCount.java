package lecture.chapter9;

import java.util.Comparator;

public class SortFullNameBySignCount implements Comparator<FullName> {

  @Override
  public int compare(FullName firstFullName, FullName secondFullName) {
    int singCountFirstFullName = firstFullName.getName().length() + firstFullName.getFamilyName().length();
    int signCountSecondFullName = secondFullName.getName().length() + secondFullName.getFamilyName().length();
    return singCountFirstFullName - signCountSecondFullName;
  }
}
