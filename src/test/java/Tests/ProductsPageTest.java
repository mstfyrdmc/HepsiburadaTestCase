package Tests;

import Model.ProductsPageModel;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;

public class ProductsPageTest {
    ProductsPageModel productsPageModel;

    public ProductsPageTest(){
        this.productsPageModel= new ProductsPageModel();
    }

    @Step("Rastgele bir urun secilir")
    public void SelectRandomProduct(){
        productsPageModel.selectProduct();
    }

    @Step("Aranan urunun geldigi gorulur")
    public void IsSearchedProductExist(){
        Assert.assertTrue("Aranan urun gelmedi",productsPageModel.isSearchedProductExist());
    }
}
