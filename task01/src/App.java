import java.io.Console;
// import java.util.Arrays;

public class App {
    
    static double result = 0;
    
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome.");
        
        Console console = System.console();
        String input = "";

        while (true) {
            input = console.readLine("> ");

            String[] line = input.split(" ");
            //System.out.println("Array: " + Arrays.toString(line)); // correct

            Double num1, num2;

            if (line[0].equals("exit")) {
                break;
            }

            if (line[0].equals("$last")) {
                line[0] = Double.toString(result);
            }

            if (line[2].equals("$last")) {
                line[2] = Double.toString(result);
            }

                num1 = Double.parseDouble(line[0]);
                num2 = Double.parseDouble(line[2]);

            switch (line[1]) {
                
                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "/":
                    result = num1 / num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                default:
                    System.out.println("invalid");
                    continue;

            }

            System.out.println(result);

        }
        System.out.println("Bye bye");
    }
    
}
