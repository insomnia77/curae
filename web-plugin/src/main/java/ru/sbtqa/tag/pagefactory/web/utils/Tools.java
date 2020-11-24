package ru.sbtqa.tag.pagefactory.web.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tools {

    public static String runCMD(String command) {
        StringBuilder output = new StringBuilder();
        BufferedReader inStreamReader = null;
        try {
            String systemCommand1;
            String systemCommand2;
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                systemCommand1 = "cmd.exe";
                systemCommand2 = "/c";
            } else {
                systemCommand1 = "/bin/bash";
                systemCommand2 = "-c";
            }
            ProcessBuilder pb = new ProcessBuilder(systemCommand1, systemCommand2, command);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            inStreamReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = inStreamReader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (Exception cmd) {
            System.out.println("Не удалось вызвать команду сmd. Stacktrace " + cmd);
        } finally {
            if (inStreamReader != null) {
                try {
                    inStreamReader.close();
                } catch (IOException ignored) {
                }
            }
        }
        return output.toString();
    }

}
