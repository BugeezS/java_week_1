import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HospitalReportGenerator {
    public static void main (String[] args) {
        //Read the CSV file
        HospitalData hospitalData = readCSVFile("hospital_data.csv");

        //Generate daily report
        DailyReport dailyreport = new DailyReport(hospitalData);
        dailyreport.generateReport("daily_report.txt");

        //Generate monthly report
        MonthlyReport monthlyReport = new MonthlyReport(hospitalData);
        monthlyReport.generateReport("monthly_report.txt");
    }

    public static HospitalData readCSVFile(String filename){
        HospitalData hospitalData = new HospitalData();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                LocalDate date = LocalDate.parse(fields [0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                int cardiologyCount = Integer.parseInt(fields[1]);
                int radiologyCount = Integer.parseInt(fields[2]);
                int visitingCount = Integer.parseInt(fields[3]);

                hospitalData.addEntry (date, cardiologyCount, radiologyCount, visitingCount);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return hospitalData;
    }
}

class HospitalData{
    private Map<LocalDate,DailyData> dataMap;

    public HospitalData(){
        dataMap= new HashMap<>();
    }

    public void addEntry(LocalDate date, int cardiologyCount, int radiologyCount, int visitingCount) {
        DailyData dailyData = new DailyData(cardiologyCount, radiologyCount, visitingCount);
        dataMap.put(date, dailyData);
    }

    public DailyData getEntry(LocalDate date){
        return dataMap.get(date);
    }

    public Map<LocalDate, DailyData> getDataMap() {
        return dataMap;
    }
}

class DailyData {
    private int  cardiologyCount;
    private int  radiologyCount;
    private int visitingCount;

    public DailyData( int cardiologyCount, int radiologyCount, int visitingCount){
        this.cardiologyCount = cardiologyCount;
        this.radiologyCount = radiologyCount;
        this.visitingCount = visitingCount;
    }

    public int getCardiologyCount() {
        return cardiologyCount;

    }

    public int getRadiologyCount() {
        return radiologyCount;
    }

    public int getVisitingCount() {
        return visitingCount;
    }
}

class DailyReport {
    private HospitalData hospitalData;

    public DailyReport(HospitalData hospitalData) {
        this.hospitalData = hospitalData;
    }

    public void generateReport (String filename) {
        try (FileWriter writer = new FileWriter(filename)){
            for (LocalDate date : hospitalData.getDataMap().keySet()){
                DailyData dailyData = hospitalData.getEntry(date);

                writer.write("Date: " + date.toString() + "\n");
                writer.write("Cardiology Count: " + dailyData.getCardiologyCount() + "\n");
                writer.write("Radiology Count: " + dailyData.getRadiologyCount() + "\n");
                writer.write("Visiting Count: " + dailyData.getVisitingCount() + "\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MonthlyReport {
    private HospitalData hospitalData;

    public MonthlyReport(HospitalData hospitalData) {
        this.hospitalData = hospitalData;
    }

    public void generateReport(String filename) {
        try(FileWriter writer = new FileWriter(filename)){
            for( Month month : Month.values()) {
                int cardiologyCount = 0;
                int radiologyCount = 0;
                int visitingCount = 0;

                for (DailyData dailyData : hospitalData.getDataMap().values()) {
                    cardiologyCount += dailyData.getCardiologyCount();
                    radiologyCount += dailyData.getRadiologyCount();
                    visitingCount += dailyData.getVisitingCount();
                }

                writer.write("Month: " + month.toString() + "\n");
                writer.write("Cardiology Count: " + cardiologyCount + "\n");
                writer.write("Radiology Count: " + radiologyCount + "\n");
                writer.write("Visiting Count: " + visitingCount + "\n");
                writer.write("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}