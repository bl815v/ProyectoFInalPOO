package model;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * La clase Correo se encarga de enviar correos electrónicos para notificar eventos importantes.
 * En este caso, se utiliza para enviar información de cuenta creada con éxito.
 *
 * @author Anderson Esteban Arévalo Rodriguez
 * @version 1.0
 */
public class Correo {

    /**
     * Envía un correo electrónico con información sobre la cuenta creada con éxito.
     *
     * @param correo Dirección de correo electrónico del destinatario.
     * @param apodo  Apodo asociado a la cuenta creada.
     * @param clave  Clave asociada a la cuenta creada.
     */
    public void enviarCorreo(String correo, String apodo, String clave) {

        // Configuración de las propiedades del sistema
        Properties propiedades = System.getProperties();
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.auth", "true");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        // Crear una sesión con autenticación
        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hide.seek3111@gmail.com", "nrvr iqnt xges dkvk");
            }
        });

        try {
            // Crear un objeto MimeMessage
            MimeMessage mensaje = new MimeMessage(sesion);

            // Establecer remitente y destinatario
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));

            // Establecer el asunto y el cuerpo del mensaje
            mensaje.setSubject("Cuenta creada con éxito");
            mensaje.setText("¡Cuenta creada con éxito! Bienvenido." + " \n" + "Su apodo es: " + apodo + " \n"
                    + "Su clave es: " + clave);

            // Enviar el mensaje
            Transport.send(mensaje);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
