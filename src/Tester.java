
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

        String[] compileCommand = new String[]{"g++", fullFile, "-o", fileName, "-std=c++11"};
        ProcessBuilder pb = new ProcessBuilder(compileCommand);
        CommandExecutor executor = new CommandExecutor(Arrays.asList(compileCommand), null);
        executor.executeCommand();
        if (executor.getError().length() != 0) {
            System.out.print(executor.getError());
        }
        return (executor.getError().length() == 0);

    }

    public ErrorMessage test(List<String> command, String input, String output) {
        CommandExecutor executor = new CommandExecutor(command, input);
        executor.executeCommand();
        String result = executor.getResult();

        if (result.equals("")) {
            return ErrorMessage.RuntimeError;
        } else {
            return (result.equals(output) ? ErrorMessage.Ok : ErrorMessage.No);
        }

    }

}
