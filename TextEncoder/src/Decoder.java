public class Decoder {

    public static void decode(String text){
        System.out.println("\nDecoding...");
        char[][] textMatrix;
        textMatrix = mountDecodedMatrix(text);
        String decodedText = showDecodedText(textMatrix);
        System.out.println(decodedText);
    }

    private static char[][] mountDecodedMatrix(String text){
        System.out.println("Mouting decoded matrix...\n");
        String[] tokens = text.split(" ");

        int rows = tokens[0].length();
        int columns = tokens.length;
        char[][] textMatrix = new char[rows][columns];

        text = text.replaceAll(" ", "");

        int indexToNotFill = rows * columns - text.length();

        int i = 0;
        int j = 0;
        int k = 0;
        for(; j < textMatrix[0].length ; j++){
            for(; k < textMatrix.length ; k++){
                if(j == textMatrix.length - 1 && k >= textMatrix[k].length - indexToNotFill);
                else{
                    textMatrix[k][j] = text.charAt(i);
                    i++;
                }
                if(i >= text.length()) break;
            }
            k = 0;
        }

        return textMatrix;
    }

    private static String showDecodedText(char[][] textMatrix){
        System.out.println("Mouting decoded text...\n");
        StringBuilder decodedText = new StringBuilder();

        for(int i = 0; i < textMatrix.length ; i++){
            for(int j = 0; j < textMatrix[i].length ; j++){
                char letter = textMatrix[i][j];
                if(letter != 0){
                    decodedText.append(letter);
                }
            }
        }

        TextReader.writeSolution(decodedText.toString());
        return decodedText.toString();
    }

}
