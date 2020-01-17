package main;

import dao.Dao;
import entity.ProductEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by XURSAND on 19.04.2019.
 */
public class ControllerMain implements Initializable {
    public Dao dao = new Dao();
    @FXML
    TextField textKokrakAylana, textBelAylana, textYuqoriBilakAylana, textPastBilakAylana,
            textOrqaKenglik, textKastyumUzunligi, textYelkaKenglik, textYengUzunligi, textBelgachaUzunligi, textFirstname, textLastname, textTelNumber, textKelishilganNarx, textAddress;
    @FXML
    TextField textDelete, textUpdate;
    @FXML
    TreeTableView mainTreetableView;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonUpdate;
    private TreeTableColumn<ProductDataModel, String> idProduct = new TreeTableColumn("№");
    private TreeTableColumn<ProductDataModel, String> firstname = new TreeTableColumn("Familya");
    private TreeTableColumn<ProductDataModel, String> lastname = new TreeTableColumn("Ismi");
    private TreeTableColumn<ProductDataModel, String> address = new TreeTableColumn("Manzili");
    private TreeTableColumn<ProductDataModel, String> telNumber = new TreeTableColumn("Telefon");
    private TreeTableColumn<ProductDataModel, String> kelNarx = new TreeTableColumn("Narxi");
    private TreeTableColumn<ProductDataModel, String> kokAylana = new TreeTableColumn("Ko'krak\naylanasi");
    private TreeTableColumn<ProductDataModel, String> belAylana = new TreeTableColumn("   Bel\naylanasi");
    private TreeTableColumn<ProductDataModel, String> yuBilakAylanasi = new TreeTableColumn("Yuqori bilak\n aylanasi");
    private TreeTableColumn<ProductDataModel, String> pastBilakAylanasi = new TreeTableColumn("Pastki bilak\n aylanasi");
    private TreeTableColumn<ProductDataModel, String> orqaKenglik = new TreeTableColumn(" Orqa\n kenglik");
    private TreeTableColumn<ProductDataModel, String> kastumUzunligi = new TreeTableColumn(" Kastum\nuzunligi");
    private TreeTableColumn<ProductDataModel, String> yelkaKenglik = new TreeTableColumn(" Yelka\nkenglik");
    private TreeTableColumn<ProductDataModel, String> yengUzunligi = new TreeTableColumn("  Yeng \nuzunligi");
    private TreeTableColumn<ProductDataModel, String> belgachaUzunlik = new TreeTableColumn("Belgacha \nuzunlik");
    private ObservableList<ProductDataModel> observableList = FXCollections.observableArrayList();
    public  ProductEntity productEntity = new ProductEntity();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDataToTable();
        setColumns();

        buttonAdd.setOnAction(event -> {

            productEntity.setAddress(textAddress.getText());
            productEntity.setFirstname(textFirstname.getText());
            productEntity.setLastname(textLastname.getText());
            productEntity.setTelNumer(textTelNumber.getText());
            productEntity.setKelNarx(textKelishilganNarx.getText());
            productEntity.setKokAylana(textKokrakAylana.getText());
            productEntity.setBelAylana(textBelAylana.getText());
            productEntity.setYuqoriBilakAyl(textYuqoriBilakAylana.getText());
            productEntity.setOrqaKenglik(textOrqaKenglik.getText());
            productEntity.setKastyumUzun(textKastyumUzunligi.getText());
            productEntity.setYelkaUzun(textYelkaKenglik.getText());
            productEntity.setYengUzunligi(textYengUzunligi.getText());
            productEntity.setBelgachaUzunligi(textBelgachaUzunligi.getText());
            productEntity.setPastkiBilakAyl(textPastBilakAylana.getText());

            ControllerIsEmpty();


        });

        buttonDelete.setOnAction(event -> {
            setTextBorderColorNull();
            TreeItem<ProductDataModel> item = (TreeItem<ProductDataModel>) mainTreetableView.getSelectionModel().getSelectedItem();
            ProductDataModel dataModel = item.getValue();
            dao.deleteProduct(item.getValue().getId());
            setDataToTable();
            setColumns();
            setTextFieldClear();

        });

//        buttonUpdate.setOnAction(event -> {
//            dao.setAllProduct(textUpdate.getText());
//        });
        mainTreetableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                TreeItem<ProductDataModel> item = (TreeItem<ProductDataModel>) mainTreetableView.getSelectionModel().getSelectedItem();
                ProductDataModel dataModel = item.getValue();
                setDataModelToFields(dataModel);
                textUpdate.setText(dataModel.getId().toString());
                System.out.println(dataModel.toString());
                setTextBorderColorNull();
            }
        });

        buttonUpdate.setOnAction(event -> {

            ProductEntity entity = fetchEntityFromModel(getDataModelFromFields());
            System.out.println(entity.toString());
            dao.updateEntity(entity, this);
            setTextFieldClear();

        });
    }

    private void ControllerIsEmpty() {
        if (textAddress.getText().isEmpty()){
            textAddress.setStyle("-fx-border-color: red");
        }
         if (textKelishilganNarx.getText().isEmpty()){
            textKelishilganNarx.setStyle("-fx-border-color: red");
        }
         if (textTelNumber.getText().isEmpty()){
            textTelNumber.setStyle("-fx-border-color: red");
        }
         if (textLastname.getText().isEmpty()){ textLastname.setStyle("-fx-border-color: red");}
         if (textYuqoriBilakAylana.getText().isEmpty()){ textYuqoriBilakAylana.setStyle("-fx-border-color: red");}
         if (textFirstname.getText().isEmpty()){ textFirstname.setStyle("-fx-border-color: red");}
         if (textBelgachaUzunligi.getText().isEmpty()){ textBelgachaUzunligi.setStyle("-fx-border-color: red");}
         if (textYengUzunligi.getText().isEmpty()){ textYengUzunligi.setStyle("-fx-border-color: red");}
         if (textYelkaKenglik.getText().isEmpty()){ textYelkaKenglik.setStyle("-fx-border-color: red");}
         if (textKastyumUzunligi.getText().isEmpty()){ textKastyumUzunligi.setStyle("-fx-border-color: red");}
         if (textOrqaKenglik.getText().isEmpty()){ textOrqaKenglik.setStyle("-fx-border-color: red");}
         if (textYuqoriBilakAylana.getText().isEmpty()){ textPastBilakAylana.setStyle("-fx-border-color: red");}
         if (textPastBilakAylana.getText().isEmpty()){ textPastBilakAylana.setStyle("-fx-border-color: red");}
         if (textBelAylana.getText().isEmpty()){ textBelAylana.setStyle("-fx-border-color: red");}
         if (textKokrakAylana.getText().isEmpty()){ textKokrakAylana.setStyle("-fx-border-color: red");}


        else{
            dao.saveProduct(productEntity);
            setDataToTable();
            setColumns();
            setTextFieldClear();
            setTextBorderColorNull();


        }

    }

    private void setTextBorderColorNull() {
        textLastname.setStyle("-fx-border-color: null");
        textFirstname.setStyle("-fx-border-color: null");
        textBelgachaUzunligi.setStyle("-fx-border-color: null");
        textYengUzunligi.setStyle("-fx-border-color: null");
        textYelkaKenglik.setStyle("-fx-border-color: null");
        textKastyumUzunligi.setStyle("-fx-border-color: null");
        textOrqaKenglik.setStyle("-fx-border-color: null");
        textYuqoriBilakAylana.setStyle("-fx-border-color: null");
        textPastBilakAylana.setStyle("-fx-border-color: null");
        textBelAylana.setStyle("-fx-border-color: null");
        textKokrakAylana.setStyle("-fx-border-color: null");
        textTelNumber.setStyle("-fx-border-color: null");
        textKelishilganNarx.setStyle("-fx-border-color: null");
        textAddress.setStyle("-fx-border-color: null");

    }

    private void setTextFieldClear() {
        textKokrakAylana.clear();
        textBelAylana.clear();
        textYuqoriBilakAylana.clear();
        textPastBilakAylana.clear();
        textOrqaKenglik.clear();
        textKastyumUzunligi.clear();
        textYelkaKenglik.clear();
        textYengUzunligi.clear();
        textYengUzunligi.clear();
        textFirstname.clear();
        textLastname.clear();
        textTelNumber.clear();
        textKelishilganNarx.clear();
        textAddress.clear();
        textBelgachaUzunligi.clear();
    }


    public void setColumns() {
        idProduct.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) ->
                new SimpleStringProperty(param.getValue().getValue().getId().toString()));
        firstname.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getFirstname()));
        lastname.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getLastname()));
        address.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getAddress()));
        telNumber.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getTelNumber()));
        kelNarx.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getKelNarx()));
        kokAylana.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getKokAylana()));
        belAylana.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getBelAylana()));
        yuBilakAylanasi.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getYuqBilakAylana()));
        pastBilakAylanasi.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getPastBilakAyl()));
        orqaKenglik.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getOrqaKenglik()));
        kastumUzunligi.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getKastumUzunligi()));
        yelkaKenglik.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getYelkaKenglik()));
        yengUzunligi.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getYengUzunligi()));
        belgachaUzunlik.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductDataModel, String> param) -> new SimpleStringProperty(param.getValue().getValue().getBelgachaUzunlik()));

        mainTreetableView.getColumns().clear();
        mainTreetableView.getColumns().addAll(idProduct, firstname, lastname, address, telNumber, kelNarx, kokAylana,
                belAylana, yuBilakAylanasi, pastBilakAylanasi, orqaKenglik, kastumUzunligi, yelkaKenglik, yengUzunligi, belgachaUzunlik);

        final TreeItem<ProductDataModel> root = new TreeItem<>();
        root.getChildren().clear();
        for (ProductDataModel productDataModel : observableList) {
            TreeItem<ProductDataModel> item = new TreeItem<>(productDataModel);
            root.getChildren().addAll(item);
        }
        mainTreetableView.setRoot(root);
        mainTreetableView.setShowRoot(false);

    }

    public void setDataToTable() {
        observableList.clear();
        observableList.addAll(dao.getAllProduct());
    }

    private void setDataModelToFields(ProductDataModel dataModel) {
        textKokrakAylana.setText(dataModel.getKokAylana());
        textBelAylana.setText(dataModel.getBelAylana());
        textYuqoriBilakAylana.setText(dataModel.getYuqBilakAylana());
        textPastBilakAylana.setText(dataModel.getPastBilakAyl());
        textOrqaKenglik.setText(dataModel.getOrqaKenglik());
        textKastyumUzunligi.setText(dataModel.getKastumUzunligi());
        textYelkaKenglik.setText(dataModel.getYelkaKenglik());
        textYengUzunligi.setText(dataModel.getYengUzunligi());
        textBelgachaUzunligi.setText(dataModel.getBelgachaUzunlik());
        textFirstname.setText(dataModel.getFirstname());
        textLastname.setText(dataModel.getLastname());
        textTelNumber.setText(dataModel.getTelNumber());
        textKelishilganNarx.setText(dataModel.getKelNarx());
        textAddress.setText(dataModel.getAddress());
    }
    private ProductDataModel getDataModelFromFields() {
        ProductDataModel dataModel = new ProductDataModel();
        dataModel.setKokAylana(textKokrakAylana.getText());
        dataModel.setBelAylana(textBelAylana.getText());
        dataModel.setYuqBilakAylana(textYuqoriBilakAylana.getText());
        dataModel.setPastBilakAyl(textPastBilakAylana.getText());
        dataModel.setOrqaKenglik(textOrqaKenglik.getText());
        dataModel.setKastumUzunligi(textKastyumUzunligi.getText());
        dataModel.setYelkaKenglik(textYelkaKenglik.getText());
        dataModel.setYengUzunligi(textYengUzunligi.getText());
        dataModel.setBelgachaUzunlik(textBelgachaUzunligi.getText());
        dataModel.setFirstname(textFirstname.getText());
        dataModel.setLastname(textLastname.getText());
        dataModel.setTelNumber(textTelNumber.getText());
        dataModel.setKelNarx(textKelishilganNarx.getText());
        dataModel.setAddress(textAddress.getText());
        return dataModel;
    }

    private ProductEntity fetchEntityFromModel(ProductDataModel dataModel) {
        ProductEntity entity = new ProductEntity();
        entity.setId(Long.valueOf(textUpdate.getText()));
        entity.setBelAylana(dataModel.getBelAylana());
        entity.setKokAylana(dataModel.getKokAylana());
        entity.setYuqoriBilakAyl(dataModel.getYuqBilakAylana());
        entity.setPastkiBilakAyl(dataModel.getPastBilakAyl());
        entity.setOrqaKenglik(dataModel.getOrqaKenglik());
        entity.setKastyumUzun(dataModel.getKastumUzunligi());
        entity.setYelkaUzun(dataModel.getYelkaKenglik());
        entity.setYengUzunligi(dataModel.getYengUzunligi());
        entity.setBelgachaUzunligi(dataModel.getBelgachaUzunlik());
        entity.setFirstname(dataModel.getFirstname());
        entity.setLastname(dataModel.getLastname());
        entity.setTelNumer(dataModel.getTelNumber());
        entity.setKelNarx(dataModel.getKelNarx());
        entity.setAddress(dataModel.getAddress());
        return entity;
    }
}
