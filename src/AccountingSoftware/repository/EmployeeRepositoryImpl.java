package AccountingSoftware.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static AccountingSoftware.util.Constants.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public void insertLine(String csvLine) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(CSV_FILE_NAME, true);
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(csvLine);

            System.out.println("Employee was added successfully!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error while closing or flushing fileWriter!!");
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<String> readCsv() {
        try {
            List<String> records = new ArrayList<>();
            try (BufferedReader bf = new BufferedReader(new FileReader(CSV_FILE_NAME))) {
                String line;
                boolean firstLineFlag = false;
                while ((line = bf.readLine()) != null) {
                    if (!firstLineFlag) {
                        firstLineFlag = true;
                        continue;
                    }
                    records.add(line);
                }
            }
            return records;
        } catch (IOException e) {
            System.out.println("Error while reading CSV file!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteLine(int employeeId) {
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            br = new BufferedReader(new FileReader(CSV_FILE_NAME));
            sb = new StringBuilder();
            String line;
            boolean firstLineFlag = true;
            while ((line = br.readLine()) != null) {
                if (firstLineFlag) {
                    firstLineFlag = false;
                    sb.append(line);
                    sb.append(NEW_LINE_SEPARATOR);
                } else {
                    String[] lineValues = line.split(COMMA_DELIMITER);
                    if (Integer.parseInt(lineValues[0]) != employeeId) {
                        sb.append(line);
                        sb.append((NEW_LINE_SEPARATOR));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("There was an error while deleting!");
            try {
                br.close();
            } catch (IOException ioE) {
                ioE.printStackTrace();
            }
        }
        writeAllInfoToDatabase(sb);
    }
    public void updateLine(int employeeId, String employeeDetails) {
        BufferedReader br = null;
        StringBuilder sb = null;
        try{
            br = new BufferedReader(new FileReader(CSV_FILE_NAME));
            sb = new StringBuilder();
            String line;
            boolean firstLineFlag = true;
            while((line = br.readLine()) != null){
                if(firstLineFlag){
                    firstLineFlag = false;
                    sb.append(line);
                    sb.append(NEW_LINE_SEPARATOR);
                }else{
                    String[] lineValues = line.split(COMMA_DELIMITER);
                    if(Integer.parseInt(lineValues[0]) == employeeId){
                        sb.append(employeeDetails);
                        sb.append(NEW_LINE_SEPARATOR);
                    }else{
                        sb.append(line);
                        sb.append(NEW_LINE_SEPARATOR);
                    }
                }
            }
        } catch(Exception e){
            System.out.println("There was an error while updating");
        }finally {
            try{
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        writeAllInfoToDatabase(sb);
    }
    private void writeAllInfoToDatabase(StringBuilder sb) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(CSV_FILE_NAME));
            fw.write(sb.toString());
        } catch (Exception e) {
            System.out.println("There was an error while writing information after a delete!");
            e.printStackTrace();
        }finally {
            try {
                if(fw != null) {
                    fw.flush();
                    fw.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}

