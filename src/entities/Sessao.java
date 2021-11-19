
package entities;

public class Sessao {
    private static String email = "larissa@hotmail.com";
    private static Usuario usuario;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Sessao.email = email;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Sessao.usuario = usuario;
    }
    
    
    
}
