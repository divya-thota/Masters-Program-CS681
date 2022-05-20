package edu.umb.cs681.hw17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCSV {

    public static void main(String[] args) {

        Path path = Path.of("Data", "PVIData.csv");

        try( Stream<String> lines = Files.lines(path) ){
            List<List<String>> matrix = lines.map(line -> {
                        return Stream.of( line.split(",") )
                                .map(value->value.substring(0, value.length()))
                                .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );

            
            List massachusetts = matrix.stream().parallel().filter((i) -> i.get(4).contains("Massachusetts")).collect(Collectors.toList());
            
            List suffolk = matrix.stream().parallel().filter((i) -> i.get(5).contains("Suffolk")).collect(Collectors.toList()).get(0);

            List Barnstable = matrix.stream().parallel().filter((i) -> i.get(5).contains("Barnstable")).collect(Collectors.toList()).get(0);

            float suffolkIR = Float.parseFloat((String) suffolk.get(8));
            float BarnstableIR = Float.parseFloat((String) Barnstable.get(8));

            String totalCases = matrix.stream().parallel().filter((i) -> i.get(4).contains("Massachusetts"))
                    .map((i) -> i.get(6)).reduce("0", (temp, result) -> String.valueOf(Integer.parseInt(temp) + Integer.parseInt(result)));


            System.out.println("Total no. of cases in Massachusetts: " + totalCases);
            System.out.println("Infection rate in Suffolk County: " + suffolk.get(8));
            System.out.println("Infection rate in Barnstable County: " + Barnstable.get(8));

            if(suffolkIR > BarnstableIR){
                System.out.println("Infection Rate in Suffolk is "+(suffolkIR-BarnstableIR)+" times more than Barnstable");
            }else{
                System.out.println("Infection Rate in Barnstable is "+(BarnstableIR-suffolkIR)+" times more than Suffolk");
            }

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
