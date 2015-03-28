
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
public class Tester {

    public boolean compile(String fullFile, String fileName) {

        String[] compileCommand = new String[]{"g++", fullFile, "-o", fileName};
        ProcessBuilder pb = new ProcessBuilder(compileCommand);
        CommandExecutor executor = new CommandExecutor(Arrays.asList(compileCommand), null);
        executor.executeCommand();
        if (executor.getError().length() != 0) {
            System.out.print(executor.getError());
        }
        return (executor.getError().length() == 0);

    }

    public boolean test(List<String> command, String input, String output) {
        CommandExecutor executor = new CommandExecutor(command, input);
        executor.executeCommand();
        String result = executor.getResult();

        if (result.equals(output)) {
            return true;
        } else {
            return false;
        }

    }

}
