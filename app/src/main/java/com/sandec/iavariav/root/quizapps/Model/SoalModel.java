package com.sandec.iavariav.root.quizapps.Model;

/**
 * Created by root on 2/3/18.
 */

public class SoalModel {
    private String ID;
    private String PERTANYAAN;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;
    private String OPTE;
    private String JAWABAN;
    private String IMG;

    public SoalModel(String ID, String PERTANYAAN, String OPTA, String OPTB, String OPTC, String OPTD, String OPTE, String JAWABAN, String IMG) {
        this.ID = ID;
        this.PERTANYAAN = PERTANYAAN;
        this.OPTA = OPTA;
        this.OPTB = OPTB;
        this.OPTC = OPTC;
        this.OPTD = OPTD;
        this.OPTE = OPTE;
        this.JAWABAN = JAWABAN;
        this.IMG = IMG;
    }

    public String getID() {
        return ID;
    }

    public String getPERTANYAAN() {
        return PERTANYAAN;
    }

    public String getOPTA() {
        return OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public String getOPTD() {
        return OPTD;
    }

    public String getOPTE() {
        return OPTE;
    }

    public String getJAWABAN() {
        return JAWABAN;
    }

    public String getIMG() {
        return IMG;
    }
}
