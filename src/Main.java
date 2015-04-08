
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

        String TASK_NAME = "matrix";
        
        String solutionsFolder = "C:\\Users\\Dimitar\\Documents\\Tester\\hw01_" + TASK_NAME;
        String inputsFolder = "C:\\Users\\Dimitar\\Documents\\Tester\\hw01_" + TASK_NAME + "_tests\\input";
        String outputsFolder = "C:\\Users\\Dimitar\\Documents\\Tester\\hw01_" + TASK_NAME + "_tests\\output";

        Tester tester = new Tester();
        FilesRetriever fr = new FilesRetriever();
        FileReader reader = new FileReader();

        List<String> solutions = fr.getFiles(solutionsFolder);
        List<String> inputs = fr.getFiles(inputsFolder);
        List<String> outputs = fr.getFiles(outputsFolder);

        displayHeader(inputs);

        solutions.stream().filter(solution -> !solution.endsWith(".exe")).forEach((solution) -> {
            int points = 0;
            String fileName = solution.substring(0, solution.length() - 4);
            String exe = solutionsFolder + "\\" + fileName;
            String cpp = exe + ".cpp";

            System.out.print(String.format("%s:", fileName));

            if (tester.compile(cpp, exe)) {

                for (int i = 0; i < inputs.size(); i++) {

                    String input = reader.getContent(inputsFolder + "\\" + inputs.get(i));
                    String output = reader.getContent(outputsFolder + "\\" + outputs.get(i));
                    List<String> command = Arrays.asList(solutionsFolder + "\\" + fileName + ".exe");
                    ErrorMessage outcome = tester.test(command, input, output);
                    if (outcome == ErrorMessage.Ok) {
                        System.out.print(String.format("\t%s", outcome));
                        points++;
                    } else if (outcome == ErrorMessage.No){
                        System.out.print(String.format("\t%s", outcome));
                    }
                    else{
                        System.out.print(String.format("\t%s", outcome));
                    }

                }
                System.out.println(String.format("\t%d points", points));
            } else {
                System.out.print(String.format("%s\t%d points\n", ErrorMessage.CompilationError, points));
            }
        });

        System.out.println();

    }

    private static void displayHeader(List<String> inputs) {
        String HEADER = "FN: ";
        for (int i = 0; i < inputs.size(); i++) {
            HEADER += String.format("\t%s%d", "Test", i + 1);
        }
        HEADER += "\tPoints";
        System.out.println(HEADER);
        addHorizontalLine("=", HEADER.length() + HEADER.length() / 3);
    }

    private static void addHorizontalLine(String string, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(string);
        }
        System.out.println();
    }

}
