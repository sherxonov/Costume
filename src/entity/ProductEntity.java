package entity;

import javax.persistence.*;

/**
 * Created by XURSAND on 19.04.2019.
 */
@Entity
@Table(name = "customerX")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String telNumer;

    @Column
    private String address;

    @Column
    private String kelNarx;

    @Column
    private String kokAylana;

    @Column
    private String belAylana;

    @Column
    private String yuqoriBilakAyl;

    @Column
    private String pastkiBilakAyl;

    @Column
    private String orqaKenglik;

    @Column
    private String kastyumUzun;

    @Column
    private String yelkaUzun;

    @Column
    private String yengUzunligi;

    @Column
    private String belgachaUzunligi;

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

    public String getTelNumer() {
        return telNumer;
    }

    public void setTelNumer(String telNumer) {
        this.telNumer = telNumer;
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

    public String getYuqoriBilakAyl() {
        return yuqoriBilakAyl;
    }

    public void setYuqoriBilakAyl(String yuqoriBilakAyl) {
        this.yuqoriBilakAyl = yuqoriBilakAyl;
    }

    public String getPastkiBilakAyl() {
        return pastkiBilakAyl;
    }

    public void setPastkiBilakAyl(String pastkiBilakAyl) {
        this.pastkiBilakAyl = pastkiBilakAyl;
    }

    public String getOrqaKenglik() {
        return orqaKenglik;
    }

    public void setOrqaKenglik(String orqaKenglik) {
        this.orqaKenglik = orqaKenglik;
    }

    public String getKastyumUzun() {
        return kastyumUzun;
    }

    public void setKastyumUzun(String kastyumUzun) {
        this.kastyumUzun = kastyumUzun;
    }

    public String getYelkaUzun() {
        return yelkaUzun;
    }

    public void setYelkaUzun(String yelkaUzun) {
        this.yelkaUzun = yelkaUzun;
    }

    public String getYengUzunligi() {
        return yengUzunligi;
    }

    public void setYengUzunligi(String yengUzunligi) {
        this.yengUzunligi = yengUzunligi;
    }

    public String getBelgachaUzunligi() {
        return belgachaUzunligi;
    }

    public void setBelgachaUzunligi(String belgachaUzunligi) {
        this.belgachaUzunligi = belgachaUzunligi;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", telNumer='" + telNumer + '\'' +
                ", address='" + address + '\'' +
                ", kelNarx='" + kelNarx + '\'' +
                ", kokAylana='" + kokAylana + '\'' +
                ", belAylana='" + belAylana + '\'' +
                ", yuqoriBilakAyl='" + yuqoriBilakAyl + '\'' +
                ", pastkiBilakAyl='" + pastkiBilakAyl + '\'' +
                ", orqaKenglik='" + orqaKenglik + '\'' +
                ", kastyumUzun='" + kastyumUzun + '\'' +
                ", yelkaUzun='" + yelkaUzun + '\'' +
                ", yengUzunligi='" + yengUzunligi + '\'' +
                ", belgachaUzunligi='" + belgachaUzunligi + '\'' +
                '}';
    }
}
