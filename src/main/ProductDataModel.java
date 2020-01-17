package main;

/**
 * Created by XURSAND on 19.04.2019.
 */
public class ProductDataModel {
    private Long id;
    private String firstname;
    private String lastname ;
    private String telNumber;
    private String address ;
    private String kelNarx ;
    private String kokAylana ;
    private String belAylana ;
    private String yuqBilakAylana ;
    private String pastBilakAyl ;
    private String orqaKenglik ;
    private String kastumUzunligi;
    private String yelkaKenglik;
    private String yengUzunligi;
    private String belgachaUzunlik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKelNarx() {
        return kelNarx;
    }

    public void setKelNarx(String kelNarx) {
        this.kelNarx = kelNarx;
    }

    public String getKokAylana() {
        return kokAylana;
    }

    public void setKokAylana(String kokAylana) {
        this.kokAylana = kokAylana;
    }

    public String getBelAylana() {
        return belAylana;
    }

    public void setBelAylana(String belAylana) {
        this.belAylana = belAylana;
    }

    public String getYuqBilakAylana() {
        return yuqBilakAylana;
    }

    public void setYuqBilakAylana(String yuqBilakAylana) {
        this.yuqBilakAylana = yuqBilakAylana;
    }

    public String getPastBilakAyl() {
        return pastBilakAyl;
    }

    public void setPastBilakAyl(String pastBilakAyl) {
        this.pastBilakAyl = pastBilakAyl;
    }

    public String getOrqaKenglik() {
        return orqaKenglik;
    }

    public void setOrqaKenglik(String orqaKenglik) {
        this.orqaKenglik = orqaKenglik;
    }

    public String getKastumUzunligi() {
        return kastumUzunligi;
    }

    public void setKastumUzunligi(String kastumUzunligi) {
        this.kastumUzunligi = kastumUzunligi;
    }

    public String getYelkaKenglik() {
        return yelkaKenglik;
    }

    public void setYelkaKenglik(String yelkaKenglik) {
        this.yelkaKenglik = yelkaKenglik;
    }

    public String getYengUzunligi() {
        return yengUzunligi;
    }

    public void setYengUzunligi(String yengUzunligi) {
        this.yengUzunligi = yengUzunligi;
    }

    public String getBelgachaUzunlik() {
        return belgachaUzunlik;
    }

    public void setBelgachaUzunlik(String belgachaUzunlik) {
        this.belgachaUzunlik = belgachaUzunlik;
    }

    @Override
    public String toString() {
        return "ProductDataModel{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", address='" + address + '\'' +
                ", kelNarx='" + kelNarx + '\'' +
                ", kokAylana='" + kokAylana + '\'' +
                ", belAylana='" + belAylana + '\'' +
                ", yuqBilakAylana='" + yuqBilakAylana + '\'' +
                ", pastBilakAyl='" + pastBilakAyl + '\'' +
                ", orqaKenglik='" + orqaKenglik + '\'' +
                ", kastumUzunligi='" + kastumUzunligi + '\'' +
                ", yelkaKenglik='" + yelkaKenglik + '\'' +
                ", yengUzunligi='" + yengUzunligi + '\'' +
                ", belgachaUzunlik='" + belgachaUzunlik + '\'' +
                '}';
    }
}
