package Tests;

import Model.ProductDetailModel;
import Model.ProductsPageModel;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;


public class ProductDetailTest {
    ProductDetailModel productDetailModel;

    public ProductDetailTest(){
        this.productDetailModel= new ProductDetailModel();
    }

    @Step("Secilen urunde degerlendirme tabina tiklanir")
    public void ClickProductReviewTab(){
         productDetailModel.clickReviewTab();
    }

    @Step("Degerlendirmeler tabindaki ilk yorum onayla butonuna basilarak onaylanır")
    public void ClickFirstApproveButton(){
        productDetailModel.clickFirstApproveButton();
    }

    @Step("<key> mesajinin geldigi gorulur")
    public void IsThankYouDisplayed(String key){
        Assert.assertEquals(key+"mesaji gelmedi",key,productDetailModel.getThankYouText());
    }

    @Step("Sirala dropbox'ina tiklanir")
    public void ClickSortDropBox(){
        productDetailModel.clickSortDropBox();
    }

    @Step("Sirala dropbox'inda elemanlarin geldigi gorulur")
    public void IsSortElementExist(){
        productDetailModel.isSortElementExist();
    }

    @Step("Urunun yildizi 4 oldugu gorulur")
    public void IsProductsStarFour(){
        productDetailModel.isStarCountBiggerThanFour();
    }
}
