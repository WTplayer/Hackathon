package Entites;

import java.io.Serializable;
import java.sql.ResultSet;

public class Erreur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int id ;
	private String moyenTransmission,professionTransmetteur,lieuErreur,
	initialErreur,natureErreur,causeErreur,populationErreur,qualifErreur,effetIndesirable,
	gravite,denomination,dci,codeATC,voie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoyenTransmission() {
		return moyenTransmission;
	}
	public void setMoyenTransmission(String moyenTransmission) {
		this.moyenTransmission = moyenTransmission;
	}
	public String getProfessionTransmetteur() {
		return professionTransmetteur;
	}
	public void setProfessionTransmetteur(String professionTransmetteur) {
		this.professionTransmetteur = professionTransmetteur;
	}
	public String getLieuErreur() {
		return lieuErreur;
	}
	public void setLieuErreur(String lieuErreur) {
		this.lieuErreur = lieuErreur;
	}
	public String getInitialErreur() {
		return initialErreur;
	}
	public void setInitialErreur(String initialErreur) {
		this.initialErreur = initialErreur;
	}
	public String getNatureErreur() {
		return natureErreur;
	}
	public void setNatureErreur(String natureErreur) {
		this.natureErreur = natureErreur;
	}
	public String getCauseErreur() {
		return causeErreur;
	}
	public void setCauseErreur(String causeErreur) {
		this.causeErreur = causeErreur;
	}
	public String getPopulationErreur() {
		return populationErreur;
	}
	public void setPopulationErreur(String populationErreur) {
		this.populationErreur = populationErreur;
	}
	public String getQualifErreur() {
		return qualifErreur;
	}
	public void setQualifErreur(String qualifErreur) {
		this.qualifErreur = qualifErreur;
	}
	public String getEffetIndesirable() {
		return effetIndesirable;
	}
	public void setEffetIndesirable(String effetIndesirable) {
		this.effetIndesirable = effetIndesirable;
	}
	public String getGravite() {
		return gravite;
	}
	public void setGravite(String gravite) {
		this.gravite = gravite;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getDci() {
		return dci;
	}
	public void setDci(String dci) {
		this.dci = dci;
	}
	public String getCodeATC() {
		return codeATC;
	}
	public void setCodeATC(String codeATC) {
		this.codeATC = codeATC;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	
	public void mapErreur(ResultSet rs) throws Exception {
		id = rs.getInt("id");
		moyenTransmission = rs.getString("moyenTransmissionSource") == null ? "" : rs.getString("moyenTransmissionSource");
		professionTransmetteur = rs.getString("professionTransmissionSource") == null ? "" :rs.getString("professionTransmissionSource");
		lieuErreur = rs.getString("lieuErreur") == null ? "" :rs.getString("lieuErreur");
		initialErreur = rs.getString("initialErreur") == null ? "" : rs.getString("initialErreur");
		natureErreur = rs.getString("natureErreur") == null ? "" :rs.getString("natureErreur");
		causeErreur = rs.getString("causeErreur") == null ? "" :rs.getString("causeErreur");
		populationErreur = rs.getString("populationErreur") == null ? "" :rs.getString("populationErreur");
		qualifErreur = rs.getString("qualifErreur") == null ? "" :rs.getString("qualifErreur");
		effetIndesirable = rs.getString("EI") == null ? "" :rs.getString("EI");
		gravite = rs.getString("graviteConsequence") == null ? "" :rs.getString("graviteConsequence");
		denomination = rs.getString("denomination") == null ? "" :rs.getString("denomination");
		dci = rs.getString("DCI") == null ? "" :rs.getString("DCI");
		codeATC = rs.getString("codeATC") == null ? "" :rs.getString("codeATC");
		voie = rs.getString("voie") == null ? "" :rs.getString("voie");
	}
}
