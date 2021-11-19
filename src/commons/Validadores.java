package commons;

public class Validadores {

    public static boolean validaEmail(String email) {
        if (!email.isBlank() && !email.isEmpty()) {
            return true;
        }else
            return false;
    }
    
    public static boolean validaNome(String nome) {
        if (!nome.isBlank() && !nome.isEmpty() && nome.matches("^[A-zÀ-ú\\s]+")) {
            return true;
        }else
            return false;
    }

    public static boolean validaData(String data) {
        if (!data.isBlank() && !data.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validaSalario(String salario) {
        if (!salario.isBlank() && !salario.isEmpty() && salario.matches("[0-9]+")) {
            return true;
        } else {
            return true;
        }
    }

    public static boolean validaSexo(String sexo) {
        if (sexo.equalsIgnoreCase("Feminino") || sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("Outros")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validaSimNao(String selecionado) {
        if (selecionado.equalsIgnoreCase("SIM") || selecionado.equalsIgnoreCase("NÃO")) {
            return true;
        } else {
            return false;
        }
    }

}
