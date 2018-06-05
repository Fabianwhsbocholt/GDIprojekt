package wm.gui.view;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import wm.controller.WMHandler;
import wm.gui.WM2018;

	public class ControllerKOSpiele implements Initializable{
		
	@FXML private Button speichern = new Button();
	@FXML TextArea ausgabe = new TextArea();
	private WMHandler wmHandler = new WMHandler();
	WM2018 mainapp;
	
	@FXML TextField achtelfinaleheim1 = new TextField();
	

	@FXML TextField achtelfinalegast1 = new TextField();
	@FXML TextField achtelfinaleheim2 = new TextField();
	@FXML TextField achtelfinalegast2 = new TextField();
	@FXML TextField achtelfinaleheim3 = new TextField();
	@FXML TextField achtelfinalegast3 = new TextField();
	@FXML TextField achtelfinaleheim4 = new TextField();
	@FXML TextField achtelfinalegast4 = new TextField();
	@FXML TextField achtelfinaleheim5 = new TextField();
	@FXML TextField achtelfinalegast5 = new TextField();
	@FXML TextField achtelfinaleheim6 = new TextField();
	@FXML TextField achtelfinalegast6 = new TextField();
	@FXML TextField achtelfinaleheim7 = new TextField();
	@FXML TextField achtelfinalegast7 = new TextField();
	@FXML TextField achtelfinaleheim8 = new TextField();
	@FXML TextField achtelfinalegast8 = new TextField();
	@FXML TextField viertelfinaleheim1 = new TextField();
	@FXML TextField viertelfinalegast1 = new TextField();
	@FXML TextField viertelfinaleheim2 = new TextField();
	@FXML TextField viertelfinalegast2 = new TextField();
	@FXML TextField viertelfinaleheim3 = new TextField();
	@FXML TextField viertelfinalegast3 = new TextField();
	@FXML TextField viertelfinaleheim4 = new TextField();
	@FXML TextField viertelfinalegast4 = new TextField();
	@FXML TextField halbfinaleheim1 = new TextField();
	@FXML TextField halbfinalegast1 = new TextField();
	@FXML TextField halbfinaleheim2 = new TextField();
	@FXML TextField halbfinalegast2 = new TextField();
	@FXML TextField platz3heim = new TextField();
	@FXML TextField platz3gast = new TextField();
	@FXML TextField finaleheim = new TextField();
	@FXML TextField finalegast = new TextField();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void speichern () {
		wmHandler.koSpieleEingeben(mainapp, ausgabe, achtelfinaleheim1, achtelfinaleheim2,
					achtelfinaleheim3, achtelfinaleheim4, achtelfinaleheim5, achtelfinaleheim6,
					achtelfinaleheim7, achtelfinaleheim8, achtelfinalegast1, achtelfinalegast2,
					achtelfinalegast3, achtelfinalegast4, achtelfinalegast5, achtelfinalegast6,
					achtelfinalegast7, achtelfinalegast8, viertelfinaleheim1,viertelfinaleheim2,
					viertelfinaleheim3, viertelfinaleheim4, viertelfinalegast1, viertelfinalegast2,
					viertelfinalegast3, viertelfinalegast4, halbfinaleheim1, halbfinaleheim2,
					halbfinalegast1, halbfinalegast2, platz3heim, platz3gast, finaleheim,
					finalegast);
		
	}
	
	public void festeWerte(WM2018 mainapp, TextArea ausgabe, TextField achtelfinaleheim1, TextField achtelfinaleheim2,
	TextField achtelfinaleheim3, TextField achtelfinaleheim4, TextField achtelfinaleheim5, TextField achtelfinaleheim6,
	TextField achtelfinaleheim7, TextField achtelfinaleheim8, TextField achtelfinalegast1, TextField achtelfinalegast2,
	TextField achtelfinalegast3, TextField achtelfinalegast4, TextField achtelfinalegast5, TextField achtelfinalegast6,
	TextField achtelfinalegast7, TextField achtelfinalegast8, TextField viertelfinaleheim1,TextField viertelfinaleheim2,
	TextField viertelfinaleheim3, TextField viertelfinaleheim4, TextField viertelfinalegast1, TextField viertelfinalegast2,
	TextField viertelfinalegast3, TextField viertelfinalegast4, TextField halbfinaleheim1, TextField halbfinaleheim2,
	TextField halbfinalegast1,TextField halbfinalegast2, TextField platz3heim, TextField platz3gast, TextField finaleheim,
	TextField finalegast) {
		
			List<String[]> koSpiele = mainapp.getPrep().getDbConnect().koSpieleSammeln();

			achtelfinaleheim1.setText(koSpiele.get(0)[0]);
			achtelfinalegast1.setText(koSpiele.get(0)[1]);
			achtelfinaleheim2.setText(koSpiele.get(1)[0]);
			achtelfinalegast2.setText(koSpiele.get(1)[1]);
			achtelfinaleheim3.setText(koSpiele.get(2)[0]);
			achtelfinalegast3.setText(koSpiele.get(2)[1]);
			achtelfinaleheim4.setText(koSpiele.get(3)[0]);
			achtelfinalegast4.setText(koSpiele.get(3)[1]);
			achtelfinaleheim5.setText(koSpiele.get(4)[0]);
			achtelfinalegast5.setText(koSpiele.get(4)[1]);
			achtelfinaleheim6.setText(koSpiele.get(5)[0]);
			achtelfinalegast6.setText(koSpiele.get(5)[1]);
			achtelfinaleheim7.setText(koSpiele.get(6)[0]);
			achtelfinalegast7.setText(koSpiele.get(6)[1]);
			achtelfinaleheim8.setText(koSpiele.get(7)[0]);
			achtelfinalegast8.setText(koSpiele.get(7)[1]);
			viertelfinaleheim1.setText(koSpiele.get(8)[0]);
			viertelfinalegast1.setText(koSpiele.get(8)[1]);
			viertelfinaleheim2.setText(koSpiele.get(9)[0]);
			viertelfinalegast2.setText(koSpiele.get(9)[1]);
			viertelfinaleheim3.setText(koSpiele.get(10)[0]);
			viertelfinalegast3.setText(koSpiele.get(10)[1]);
			viertelfinaleheim4.setText(koSpiele.get(11)[0]);
			viertelfinalegast4.setText(koSpiele.get(11)[1]);
			halbfinaleheim1.setText(koSpiele.get(12)[0]);
			halbfinalegast1.setText(koSpiele.get(12)[1]);
			halbfinaleheim2.setText(koSpiele.get(13)[0]);
			halbfinalegast2.setText(koSpiele.get(13)[1]);
			platz3heim.setText(koSpiele.get(14)[0]);
			platz3gast.setText(koSpiele.get(14)[1]);
			finaleheim.setText(koSpiele.get(15)[0]);
			finalegast.setText(koSpiele.get(15)[1]);
	
		
	}
	
	public TextField getAchtelfinaleheim1() {
		return achtelfinaleheim1;
	}

	public void setAchtelfinaleheim1(TextField achtelfinaleheim1) {
		this.achtelfinaleheim1 = achtelfinaleheim1;
	}

	public TextField getAchtelfinalegast1() {
		return achtelfinalegast1;
	}

	public void setAchtelfinalegast1(TextField achtelfinalegast1) {
		this.achtelfinalegast1 = achtelfinalegast1;
	}

	public TextField getAchtelfinaleheim2() {
		return achtelfinaleheim2;
	}

	public void setAchtelfinaleheim2(TextField achtelfinaleheim2) {
		this.achtelfinaleheim2 = achtelfinaleheim2;
	}

	public TextField getAchtelfinalegast2() {
		return achtelfinalegast2;
	}

	public void setAchtelfinalegast2(TextField achtelfinalegast2) {
		this.achtelfinalegast2 = achtelfinalegast2;
	}

	public TextField getAchtelfinaleheim3() {
		return achtelfinaleheim3;
	}

	public void setAchtelfinaleheim3(TextField achtelfinaleheim3) {
		this.achtelfinaleheim3 = achtelfinaleheim3;
	}

	public TextField getAchtelfinalegast3() {
		return achtelfinalegast3;
	}

	public void setAchtelfinalegast3(TextField achtelfinalegast3) {
		this.achtelfinalegast3 = achtelfinalegast3;
	}

	public TextField getAchtelfinaleheim4() {
		return achtelfinaleheim4;
	}

	public void setAchtelfinaleheim4(TextField achtelfinaleheim4) {
		this.achtelfinaleheim4 = achtelfinaleheim4;
	}

	public TextField getAchtelfinalegast4() {
		return achtelfinalegast4;
	}

	public void setAchtelfinalegast4(TextField achtelfinalegast4) {
		this.achtelfinalegast4 = achtelfinalegast4;
	}

	public TextField getAchtelfinaleheim5() {
		return achtelfinaleheim5;
	}

	public void setAchtelfinaleheim5(TextField achtelfinaleheim5) {
		this.achtelfinaleheim5 = achtelfinaleheim5;
	}

	public TextField getAchtelfinalegast5() {
		return achtelfinalegast5;
	}

	public void setAchtelfinalegast5(TextField achtelfinalegast5) {
		this.achtelfinalegast5 = achtelfinalegast5;
	}

	public TextField getAchtelfinaleheim6() {
		return achtelfinaleheim6;
	}

	public void setAchtelfinaleheim6(TextField achtelfinaleheim6) {
		this.achtelfinaleheim6 = achtelfinaleheim6;
	}

	public TextField getAchtelfinalegast6() {
		return achtelfinalegast6;
	}

	public void setAchtelfinalegast6(TextField achtelfinalegast6) {
		this.achtelfinalegast6 = achtelfinalegast6;
	}

	public TextField getAchtelfinaleheim7() {
		return achtelfinaleheim7;
	}

	public void setAchtelfinaleheim7(TextField achtelfinaleheim7) {
		this.achtelfinaleheim7 = achtelfinaleheim7;
	}

	public TextField getAchtelfinalegast7() {
		return achtelfinalegast7;
	}

	public void setAchtelfinalegast7(TextField achtelfinalegast7) {
		this.achtelfinalegast7 = achtelfinalegast7;
	}

	public TextField getAchtelfinaleheim8() {
		return achtelfinaleheim8;
	}

	public void setAchtelfinaleheim8(TextField achtelfinaleheim8) {
		this.achtelfinaleheim8 = achtelfinaleheim8;
	}

	public TextField getAchtelfinalegast8() {
		return achtelfinalegast8;
	}

	public void setAchtelfinalegast8(TextField achtelfinalegast8) {
		this.achtelfinalegast8 = achtelfinalegast8;
	}

	public TextField getViertelfinaleheim1() {
		return viertelfinaleheim1;
	}

	public void setViertelfinaleheim1(TextField viertelfinaleheim1) {
		this.viertelfinaleheim1 = viertelfinaleheim1;
	}

	public TextField getViertelfinalegast1() {
		return viertelfinalegast1;
	}

	public void setViertelfinalegast1(TextField viertelfinalegast1) {
		this.viertelfinalegast1 = viertelfinalegast1;
	}

	public TextField getViertelfinaleheim2() {
		return viertelfinaleheim2;
	}

	public void setViertelfinaleheim2(TextField viertelfinaleheim2) {
		this.viertelfinaleheim2 = viertelfinaleheim2;
	}

	public TextField getViertelfinalegast2() {
		return viertelfinalegast2;
	}

	public void setViertelfinalegast2(TextField viertelfinalegast2) {
		this.viertelfinalegast2 = viertelfinalegast2;
	}

	public TextField getViertelfinaleheim3() {
		return viertelfinaleheim3;
	}

	public void setViertelfinaleheim3(TextField viertelfinaleheim3) {
		this.viertelfinaleheim3 = viertelfinaleheim3;
	}

	public TextField getViertelfinalegast3() {
		return viertelfinalegast3;
	}

	public void setViertelfinalegast3(TextField viertelfinalegast3) {
		this.viertelfinalegast3 = viertelfinalegast3;
	}

	public TextField getViertelfinaleheim4() {
		return viertelfinaleheim4;
	}

	public void setViertelfinaleheim4(TextField viertelfinaleheim4) {
		this.viertelfinaleheim4 = viertelfinaleheim4;
	}

	public TextField getViertelfinalegast4() {
		return viertelfinalegast4;
	}

	public void setViertelfinalegast4(TextField viertelfinalegast4) {
		this.viertelfinalegast4 = viertelfinalegast4;
	}

	public TextField getHalbfinaleheim1() {
		return halbfinaleheim1;
	}

	public void setHalbfinaleheim1(TextField halbfinaleheim1) {
		this.halbfinaleheim1 = halbfinaleheim1;
	}

	public TextField getHalbfinalegast1() {
		return halbfinalegast1;
	}

	public void setHalbfinalegast1(TextField halbfinalegast1) {
		this.halbfinalegast1 = halbfinalegast1;
	}

	public TextField getHalbfinaleheim2() {
		return halbfinaleheim2;
	}

	public void setHalbfinaleheim2(TextField halbfinaleheim2) {
		this.halbfinaleheim2 = halbfinaleheim2;
	}

	public TextField getHalbfinalegast2() {
		return halbfinalegast2;
	}

	public void setHalbfinalegast2(TextField halbfinalegast2) {
		this.halbfinalegast2 = halbfinalegast2;
	}

	public TextField getPlatz3heim() {
		return platz3heim;
	}

	public void setPlatz3heim(TextField platz3heim) {
		this.platz3heim = platz3heim;
	}

	public TextField getPlatz3gast() {
		return platz3gast;
	}

	public void setPlatz3gast(TextField platz3gast) {
		this.platz3gast = platz3gast;
	}

	public TextField getFinaleheim() {
		return finaleheim;
	}

	public void setFinaleheim(TextField finaleheim) {
		this.finaleheim = finaleheim;
	}

	public TextField getFinalegast() {
		return finalegast;
	}

	public void setFinalegast(TextField finalegast) {
		this.finalegast = finalegast;
	}
	
	public WM2018 getMainapp() {
		return mainapp;
   }
   
   public void setMainapp(WM2018 mainapp) {
		this.mainapp = mainapp;
   }
	
   public void setTextArea(TextArea ausgabe) {
		this.ausgabe = ausgabe;
		
	}

	public TextArea getAusgabeVerb() {
		return ausgabe;
	}


}
