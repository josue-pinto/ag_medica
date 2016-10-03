
/**
 *
 * @author Josue Jr, Jair Silva, Vitor
 */
public class Paciente {
    private int id_pac;
    private String nm_pac;
    private String tel_pac;    
    private String email_pac;
    /**
     * @return codigo do paciente
     */
    public int getIdPac() {
        return id_pac;
    }

    /**
     * @param id_pac the id_pac to set
     */
    public void setId_Pac(int id_pac) {
        this.id_pac = id_pac;
    }

    /**
     * @return the nm_sexo
     */
    public String getNm_Pac() {
        return nm_pac;
    }

    /**
     * @param nm_pac the nm_pac to set
     */
    public void setNm_Pac(String nm_pac) {
        this.nm_pac = nm_pac;
    }

    /**
     * @return the tel_pac
     */
    public String getTel_Pac() {
        return tel_pac;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTel_Pac(String tel_pac) {
        this.tel_pac = tel_pac;
    }

    /**
     * @return the email
     */
    public String getEmail_Pac() {
        return email_pac;
    }

    /**
     * @param email the email to set
     */
    public void setEmail_Pac(String email_pac) {
        this.email_pac = email_pac;
    }
    
}
