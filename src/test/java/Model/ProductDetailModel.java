package Model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailModel extends BaseModel{
    public static By tabProductReview = By.id("productReviewsTab");
    public static By btnApprove = By.xpath("(//div[@class='hermes-ReviewCard-module-tAGUS'])[1]");
    public static By lblThankYou = By.xpath("(//span[@class='hermes-ReviewCard-module-1ZiTv'])[1]");
    public static By drpSort = By.xpath("//*[@class='hermes-Sort-module-pGjws']");
    public static By sortElements = By.xpath("//*[contains(@class,'hermes-Sort-module-2npZQ')]");
    public static By lblProductsStar = By.xpath("//span[@class='ratings active']");

    public void clickReviewTab(){
        scrollToElement(findElement(tabProductReview));
        clickElement(tabProductReview);
    }

    public void clickFirstApproveButton(){
        scrollToElement(findElement(tabProductReview));
        clickElement(btnApprove);
    }

    public String getThankYouText(){
       return getText(lblThankYou);
    }

    public  void scrollToElement(WebElement element){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void  clickSortDropBox(){
        clickElement(drpSort);
    }

    public void isSortElementExist(){
        List<WebElement> value = findElements(sortElements);
        List<String> elements = new ArrayList<>();
        elements.add("En yeni değerlendirme");
        elements.add("En faydalı değerlendirme");
        elements.add("Puana göre azalan");
        elements.add("Puana göre artan");
        for (int i=0;i<elements.size();i++){
            Assert.assertEquals(elements.get(i),value.get(i).getText());
        }
    }

    public String getProductStar(){
        String star= getElementValue(lblProductsStar,"style");
      String star1= star.replace("width:","");
      String star2 = star1.replace("%;","");
      String star3= star2.trim();
        return star3;
    }

    public boolean isStarCountBiggerThanFour(){
        int star= Integer.parseInt(getProductStar());
        if (star>79){
            return  true;
        }
        else{
            return false;
        }
    }
}
