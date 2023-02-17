import domain.CalculatriceOutput;
import domain.ParseFile;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            CalculatriceOutput.getStarted();
            return;
        }

        String filename = args[0];
        String operator = args[1];
        boolean logging = args.length == 3 && args[2].equals("-log");

        int total = 0;
        int lineNumber = 1;

        ParseFile parseFile = new ParseFile(lineNumber, total, operator, logging);
        parseFile.readFile(filename);


        String operationName;
        switch (operator) {
            case "+" -> operationName = "addition";
            case "-" -> operationName = "subtraction";
            case "*" -> operationName = "multiplication";
            default -> {
                CalculatriceOutput.invalidOperator(operator);
                return;
            }
        }

        CalculatriceOutput.getTotals(parseFile.getTotal(), operationName);
        if (logging) {
            CalculatriceOutput.endLog(operationName);
        }
    }
}
