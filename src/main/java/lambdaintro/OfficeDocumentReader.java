package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {

  public static final String REGEX = ".*\\.(docx|pptx|xlsx)$";

  public List<File> listOfficeDocuments(File path) {
    List<File> sortedFileList = Arrays.asList(path.listFiles(f -> f.isFile() && f.getName().toLowerCase().matches(REGEX)));
    System.out.println(sortedFileList);
    sortedFileList.sort(Comparator.comparing(File::getName));
    return sortedFileList;
  }
}
