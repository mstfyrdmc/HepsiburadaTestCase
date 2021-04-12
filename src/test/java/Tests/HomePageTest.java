package Tests;

import Model.HomePageModel;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;

public class HomePageTest {
    HomePageModel homePageModel;

    public HomePageTest(){
        this.homePageModel= new HomePageModel();
    }

    @Step("<key> sitesine giris yapilir")
    public void  initializeWebSite(String url){
        homePageModel.GoToUrl(url);
    }

    @Step("Arama alaninda <key> aratilir")
    public void SearchProduct(String productName){
        homePageModel.SearchProduct(productName);
    }


}
