package lippia.web;

public class utils {

    public static String correoAleatorio(String email) {
        int numero = (int) (Math.random() * 10000);

        switch (email) {
            case "randomEmail":
                return email + "_" + numero + "@gmail.com";
            case "emailInvalidSinArroba":
                return email + "_" + numero + "gmail.com";
            default:
                return " ";
        }

    }
}