public class Encoder {

    public static String encode(String text){
        System.out.println("\nEncoding...");
        char[][] textMatrix;
        textMatrix = mountEncodedMatrix(text);
        String encodedText = showEncodedText(textMatrix);
        System.out.println(encodedText + "\n");

        return encodedText;
    }

    private static char[][] mountEncodedMatrix(String text){
        System.out.println("Mouting encoded matrix...\n");
        text = text.replaceAll("[^a-zA-Z0-9]","");

        double sqrtResult = Math.sqrt(text.length());

        char[][] charMatrix = sqrtResult % 1 == 0 ?
                new char[(int)sqrtResult][(int)sqrtResult] : new char[(int)sqrtResult][(int)Math.ceil(sqrtResult)];

        int i = 0;
        for(int j = 0; j < charMatrix.length; j++){
            for(int k = 0; k < charMatrix[j].length; k++){
                charMatrix[j][k] = text.charAt(i);
                i++;
                if(i >= text.length()) break;
            }
        }

        return charMatrix;
    }

    private static String showEncodedText(char[][] textMatrix){
        System.out.println("Mouting encoded text...\n");

        StringBuilder encodedText = new StringBuilder();

        int i = 0;
        int j = 0;
        for(; i < textMatrix[0].length ; i++){
            for(; j < textMatrix.length ; j++){
                char letter = textMatrix[j][i];
                if(letter != 0){
                    encodedText.append(letter);
                }
            }
            encodedText.append(" ");
            j = 0;
        }

        TextReader.writeSolution(encodedText.toString());
        return encodedText.toString();
    }
}
