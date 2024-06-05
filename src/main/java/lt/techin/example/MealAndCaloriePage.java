package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MealAndCaloriePage {


    @FindBy(xpath = "//*//input[@id=\"item-name\"]")
    private WebElement mealInput;

    @FindBy(css = "#item-calories")
    private WebElement caloriesInput;

    @FindBy(css = ".add-btn.blue.darken-3")
    private WebElement addMealButton;

    @FindBy(xpath = "//*[@id=\"item-0\"]/strong")
    private WebElement addedFood;

    @FindBy(xpath = "//*[@id=\"item-0\"]/em")
    private WebElement addedFoodCaloriesAmount;

    @FindBy(css = ".total-calories")
    private WebElement caloriesResult;

    @FindBy(xpath = "//ul[@id='item-list']/li[last()]/a")
    private WebElement clickPencilIcon;
    @FindBy(xpath = "//*/div[@class='container']//form[@class='col']/div/button[2]")
    private WebElement updateMealButton;

    @FindBy(css = ".btn.delete-btn.red")
    private WebElement deleteMealButton;

    @FindBy(css = ".pull-right")
    private WebElement backButton;

    @FindBy(css = ".blue.btn.clear-btn.lighten-3")
    private WebElement clearAllButton;

    @FindBy(xpath = "//*//ul[@id=\"item-list\"]")
    private List<WebElement> mealsList;

    WebDriver driver;

    public MealAndCaloriePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputFoodNameIntoMealInputField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mealInput));
        mealInput.sendKeys("Fried fish");
    }

    public void inputValueOfCaloriesIntoCaloriesInputField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(caloriesInput));
        caloriesInput.sendKeys("800");
    }

    public void inputSecondFoodNameIntoMealInputField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mealInput));
        mealInput.sendKeys("Cooked steak");
    }

    public void inputValueOfCaloriesIntoCaloriesInputFieldOfSecondMeal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(caloriesInput));
        caloriesInput.sendKeys("2000");
    }

    public void inputThirdFoodNameIntoMealInputField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mealInput));
        mealInput.sendKeys("Meat soup");
    }

    public void inputValueOfCaloriesIntoCaloriesInputFieldOfThirdMeal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(caloriesInput));
        caloriesInput.sendKeys("1300");
    }

    //input value getters
    public String getMealInputValue() {
        return mealInput.getAttribute("value");
    }

    public String getCaloriesInputValue() {
        return caloriesInput.getAttribute("value");
    }

    public String getSecondMealInputValue(){
        return mealInput.getAttribute("value");
    }

    public String getSecondMealCaloriesInputValue(){
        return caloriesInput.getAttribute("value");
    }

    public String getThirdMealInputValue(){
        return mealInput.getAttribute("value");
    }
    public String getThirdMealCaloriesInput(){
        return caloriesInput.getAttribute("value");
    }
    /*
    public String getAddedFoodResultName(){
        return addedFood.getAttribute("value");
    }

    public String getAddedFoodCaloriesResultAmount(){
        return addedFoodCaloriesAmount.getAttribute("value");
    }

     */
    public String getCaloriesResultValue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(caloriesResult));
        return caloriesResult.getText(); // Retrieve the text content of the element
    }


    public void clickOnAddMealButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addMealButton));
        addMealButton.click();
    }


    //click on pencil icon
    public void clickOnPencilIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickPencilIcon));
        clickPencilIcon.click();

    }

    //click on update meal button
    public void clickOnUpdateMealButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(updateMealButton));
        updateMealButton.click();
    }

    //click on delete meal button
    public void clickOnDeleteMealButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(deleteMealButton));
        deleteMealButton.click();
    }

    public List<WebElement> mealsAfterAddition() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(mealsList));
        return driver.findElements(By.cssSelector("#item-list .collection-item"));
    }

    //click on back button
    public void clickOnBackButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }

    // click on all clear button
    public void clickAllClearButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(clearAllButton));
        clearAllButton.click();

    }
}
