import java.util.Scanner;

public class App {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int option;

        System.out.println("Remember, you need fill the input file with the message what you want to encoding or decoding");
        System.out.println("Please choose\n[0] to encoding a message\n[1] to decoding a message");
        option = in.nextInt();

        String textInOneLine;
        textInOneLine = TextReader.readTextOf("input.txt");

        switch(option){
            case 0:
                Encoder.encode(textInOneLine);
                break;
            case 1:
                Decoder.decode(textInOneLine);
                break;
            default:
                System.out.println("Invalid option, please next time run with a valid command");
        }

    }
}
