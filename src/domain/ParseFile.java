package domain;

import java.io.BufferedReader;
import java.io.IOException;

public class ParseFile {
    private  int lineNumber;
    private  int total;
    private final String operator;
    private final boolean logging;

    public ParseFile(int lineNumber, int total, String operator, boolean logging) {
        this.lineNumber = lineNumber;
        this.total = total;
        this.operator = operator;
        this.logging = logging;
    }

    public void readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (lineNumber == 1) {
                    CalculatriceOutput.inputNumber(number);
                } else {
                    CalculatriceOutput.calculLogger(total, operator, number);
                }

                switch (operator) {
                    case "+" -> total += number;
                    case "-" -> total -= number;
                    case "*" -> total *= number;
                }

                if (logging) {
                    CalculatriceOutput.operationLogger(total, line, lineNumber, number);
                }

                lineNumber++;
            }
        } catch (IOException e) {
            CalculatriceOutput.errorReadingFile(e.getMessage());
        } catch (NumberFormatException e) {
            CalculatriceOutput.invalidNumber(e.getMessage());
        }
    }

    public int getTotal() {
        return total;
    }

}
