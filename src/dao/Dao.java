package dao;

import config.MySessionFactory;
import entity.ProductEntity;
import main.ControllerMain;
import main.ProductDataModel;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XURSAND on 19.04.2019.
 */
public class Dao {
    public static Session session = MySessionFactory.getSession();
    public static void saveProduct(ProductEntity productEntity){
        session.beginTransaction();
        session.save(productEntity);
        session.getTransaction().commit();
    }
    public ProductEntity getProductEntity(Long id){

        return (ProductEntity) session.get(ProductEntity.class, id);
    }

    public void deleteProduct(Long id){

        ProductEntity productEntity = getProductEntity(id);
        session.beginTransaction();
        session.delete(productEntity);
        session.getTransaction().commit();

    }

    public List<ProductDataModel> getAllProduct(){
        String queryString = "From ProductEntity s";
        Query query = session.createQuery(queryString);
        List<ProductEntity> productEntities = query.list();
        List<ProductDataModel> dataModels = new ArrayList<>();
        productEntities.forEach(productEntity -> {
            ProductDataModel dataModel = new ProductDataModel();
            dataModel.setAddress(productEntity.getAddress());
            dataModel.setId(productEntity.getId());
            dataModel.setBelAylana(productEntity.getBelAylana());
            dataModel.setBelgachaUzunlik(productEntity.getBelgachaUzunligi());
            dataModel.setFirstname(productEntity.getFirstname());
            dataModel.setKastumUzunligi(productEntity.getKastyumUzun());
            dataModel.setKelNarx(productEntity.getKelNarx());
            dataModel.setKokAylana(productEntity.getKokAylana());
            dataModel.setLastname(productEntity.getLastname());
            dataModel.setOrqaKenglik(productEntity.getOrqaKenglik());
            dataModel.setPastBilakAyl(productEntity.getPastkiBilakAyl());
            dataModel.setTelNumber(productEntity.getTelNumer());
            dataModel.setYelkaKenglik(productEntity.getYelkaUzun());
            dataModel.setYengUzunligi(productEntity.getYengUzunligi());
            dataModel.setYuqBilakAylana(productEntity.getYuqoriBilakAyl());
            dataModels.add(dataModel);
        });
        return dataModels;
        }

        public void updateEntity(ProductEntity entity, ControllerMain controllerMain) {
            session.merge(entity);
            controllerMain.setDataToTable();
            controllerMain.setColumns();
        }
}
