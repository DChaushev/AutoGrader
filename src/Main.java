
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dimitar
 */
public class Main {

    public static void main(String[] args) {

        String solutionsFolder = "C:\\Users\\Dimitar\\Documents\\Tester\\hw01";
        String inputsFolder = "C:\\Users\\Dimitar\\Documents\\Tester\\hw01_tests\\input";
        String outputsFolder = "C:\\Users\\Dimitar\\Documents\\Tester\\hw01_tests\\output";

        Tester tester = new Tester();
        FilesRetriever fr = new FilesRetriever();
        FileReader reader = new FileReader();

        List<String> solutions = fr.getFiles(solutionsFolder);
        List<String> inputs = fr.getFiles(inputsFolder);
        List<String> outputs = fr.getFiles(outputsFolder);

        solutions.stream().filter(solution -> !solution.endsWith(".exe")).forEach((solution) -> {
            int points = 0;
            String fileName = solution.substring(0, solution.length() - 4);
            String exe = solutionsFolder + "\\" + fileName;
            String cpp = exe + ".cpp";

            System.out.print(fileName + ": ");

            if (tester.compile(cpp, exe)) {

                for (int i = 0; i < inputs.size(); i++) {

                    String input = reader.getContent(inputsFolder + "\\" + inputs.get(i));
                    String output = reader.getContent(outputsFolder + "\\" + outputs.get(i));
                    List<String> command = Arrays.asList(solutionsFolder + "\\" + fileName + ".exe");
                    if (tester.test(command, input, output)) {
                        System.out.print("YES ");
                        points++;
                    } else {
                        System.out.print("NO  ");
                    }

                }
                System.out.println(String.format(" %d points", points));
            } else {
                System.out.print(String.format("CE%12d points\n", points));
            }
        });

        System.out.println();

    }

}
