package lt.techin.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MealAndCalorieTest {

    WebDriver driver;
    private void mealAndCaloriesInputForASingleMeal() {
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);

        //input meal into a meal input field
        mealAndCaloriePage.inputFoodNameIntoMealInputField();
        //confirm the correct output
        String friedFish = mealAndCaloriePage.getMealInputValue();
        assertEquals("Fried fish", friedFish);
        System.out.println("Input food: " + friedFish);
        //input calories amount into calories input field
        mealAndCaloriePage.inputValueOfCaloriesIntoCaloriesInputField();
        //confirm the correct output
        String caloriesInputValue = mealAndCaloriePage.getCaloriesInputValue();
        assertEquals("800", caloriesInputValue);
        System.out.println("Calories amount: " + caloriesInputValue);
    }

    private void multipleMeals() {
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);
        //add first meal
        mealAndCaloriePage.inputFoodNameIntoMealInputField();
        String friedFish = mealAndCaloriePage.getMealInputValue();
        assertEquals("Fried fish", friedFish);
        System.out.println("Input food: " + friedFish);
        //add first meal calories values
        mealAndCaloriePage.inputValueOfCaloriesIntoCaloriesInputField();
        String caloriesInputValue = mealAndCaloriePage.getCaloriesInputValue();
        assertEquals("800", caloriesInputValue);
        System.out.println("Calories amount: " + caloriesInputValue);
        //'add meal' click
        mealAndCaloriePage.clickOnAddMealButton();


        //add second meal
        mealAndCaloriePage.inputSecondFoodNameIntoMealInputField();
        String cookedSteak = mealAndCaloriePage.getSecondMealInputValue();
        assertEquals("Cooked steak", cookedSteak);
        System.out.println("Input food: " + cookedSteak);
        //add second meal calories values
        mealAndCaloriePage.inputValueOfCaloriesIntoCaloriesInputFieldOfSecondMeal();
        String caloriesInputValue2 = mealAndCaloriePage.getSecondMealCaloriesInputValue();
        assertEquals("2000", caloriesInputValue2);
        System.out.println("Calories amount: " + caloriesInputValue2);
        //'add meal' button click
        mealAndCaloriePage.clickOnAddMealButton();

        //add third meal
        mealAndCaloriePage.inputThirdFoodNameIntoMealInputField();
        String meatSoup = mealAndCaloriePage.getThirdMealInputValue();
        assertEquals("Meat soup", meatSoup);
        System.out.println("Input food: " + meatSoup);
        //add third meal calories values
        mealAndCaloriePage.inputValueOfCaloriesIntoCaloriesInputFieldOfThirdMeal();
        String caloriesInputValue3 = mealAndCaloriePage.getThirdMealCaloriesInput();
        assertEquals("1300", caloriesInputValue3);
        System.out.println("Calories amount: " + caloriesInputValue3);
        //'add meal' button click
        mealAndCaloriePage.clickOnAddMealButton();
    }

    private void updateMeal() throws InterruptedException {
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);

        //input meal into a meal input field
        mealAndCaloriePage.inputFoodNameIntoMealInputField();
        //input calories amount into calories input field
        mealAndCaloriePage.inputValueOfCaloriesIntoCaloriesInputField();
        //click 'add meal' button'
        mealAndCaloriePage.clickOnAddMealButton();
        //click on pencil button
        mealAndCaloriePage.clickOnPencilIcon();
        //wait for interactions
        Thread.sleep(5000);
        //click update meal button
        mealAndCaloriePage.clickOnUpdateMealButton();
        System.out.println("The update button was clicked");
    }

    private void deleteMeals() throws InterruptedException {
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);

        mealAndCaloriePage.inputFoodNameIntoMealInputField();
        String friedFish = mealAndCaloriePage.getMealInputValue();
        assertEquals("Fried fish", friedFish);
        System.out.println("Input food: " + friedFish);
        //add first meal calories values
        mealAndCaloriePage.inputValueOfCaloriesIntoCaloriesInputField();
        String caloriesInputValue = mealAndCaloriePage.getCaloriesInputValue();
        assertEquals("800", caloriesInputValue);
        System.out.println("Calories amount: " + caloriesInputValue);
        //'add meal' click
        mealAndCaloriePage.clickOnAddMealButton();

        //add second meal
        mealAndCaloriePage.inputSecondFoodNameIntoMealInputField();
        String cookedSteak = mealAndCaloriePage.getSecondMealInputValue();
        assertEquals("Cooked steak", cookedSteak);
        System.out.println("Input food: " + cookedSteak);
        //add second meal calories values
        mealAndCaloriePage.inputValueOfCaloriesIntoCaloriesInputFieldOfSecondMeal();
        String caloriesInputValue2 = mealAndCaloriePage.getSecondMealCaloriesInputValue();
        assertEquals("2000", caloriesInputValue2);
        System.out.println("Calories amount: " + caloriesInputValue2);
        //'add meal' button click
        mealAndCaloriePage.clickOnAddMealButton();

        //add third meal
        mealAndCaloriePage.inputThirdFoodNameIntoMealInputField();
        String meatSoup = mealAndCaloriePage.getThirdMealInputValue();
        assertEquals("Meat soup", meatSoup);
        System.out.println("Input food: " + meatSoup);
        //add third meal calories values
        mealAndCaloriePage.inputValueOfCaloriesIntoCaloriesInputFieldOfThirdMeal();
        String caloriesInputValue3 = mealAndCaloriePage.getThirdMealCaloriesInput();
        assertEquals("1300", caloriesInputValue3);
        System.out.println("Calories amount: " + caloriesInputValue3);
        //'add meal' button click
        mealAndCaloriePage.clickOnAddMealButton();
        //click on pencil button
        mealAndCaloriePage.clickOnPencilIcon();
        //wait for interactions
        Thread.sleep(3000);
        //click on delete button
        mealAndCaloriePage.clickOnDeleteMealButton();
        System.out.println("The delete button was clicked");
    }



    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/tracalorie/?classId=e83a1e60-d212-4fa4-9e1c-f89284b2328a&assignmentId=bf2480e2-ae85-49e3-bbb4-6fc77a9d30d8&submissionId=3668ceda-e292-4c88-60c7-0796af91eb2d");
        driver.manage().window().maximize();
    }

    //Test 1
    @Test
    void mealAndCaloriesInputTest(){
        mealAndCaloriesInputForASingleMeal();
    }

    //Test 2
    @Test
    void addMealTest(){
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);

        mealAndCaloriesInputForASingleMeal();

        //click 'add meal' button
        mealAndCaloriePage.clickOnAddMealButton();
        System.out.println("The add meal button was clicked");

        List<WebElement> mealsList = mealAndCaloriePage.mealsAfterAddition();
        assertEquals(1, mealsList.size(), "The number of meals after addition should be 1");

        // assertion that the correct calories amount was added
        String totalCalories = mealAndCaloriePage.getCaloriesResultValue();
        assertEquals("800", totalCalories.trim(), "Total calories should be 800 after adding a meal");
        System.out.println("Total calories amount: " + totalCalories);


    }
    //Test 3
    @Test
    void multipleMealsAndCaloriesAddition(){
        multipleMeals();
    }

    // Test 4
    @Test
    public void testMealsAfterAddition() {
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);


        multipleMeals();
        // wait for list to be filled
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".collection-item"), 2));

        //list after meals addition
        List<WebElement> afterAddition = mealAndCaloriePage.mealsAfterAddition();
        System.out.println("Meals after addition: " + afterAddition.size());

        // assertin that the meals were added to the list
        assertEquals(3, afterAddition.size(), "Three meals should be added to the list");
    }

    // Test 5
    @Test
    public void testMealsAfterRemoval() {
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);

        multipleMeals();
        // initial meals list
        List<WebElement> priorRemoval = mealAndCaloriePage.mealsAfterAddition();
        assertEquals(3, priorRemoval.size(), "Meal list size before removal is incorrect");

        // meal removal
        mealAndCaloriePage.clickOnPencilIcon();
        mealAndCaloriePage.clickOnDeleteMealButton();

        // list after removal of a meal
        List<WebElement> afterRemoval = mealAndCaloriePage.mealsAfterAddition();

        // assertion the meal was removed
        assertEquals(priorRemoval.size() - 1, afterRemoval.size());
    }

    //Test 6
    @Test
    void updateMealTest() throws InterruptedException{
        updateMeal();
    }


    //Test 7
    @Test
    void deleteMealTest()  throws InterruptedException {
        deleteMeals();

    }


    //Test 8
    @Test
    void clickOnBackButtonTest() throws InterruptedException{
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);

        mealAndCaloriesInputForASingleMeal();
        //click 'add meal' button
        mealAndCaloriePage.clickOnAddMealButton();
        //click on pencil button
        mealAndCaloriePage.clickOnPencilIcon();
        //wait for interactions
        Thread.sleep(3000);
        //click on back button
        mealAndCaloriePage.clickOnBackButton();
        System.out.println("The back button was clicked");
    }
    //Test 9
    @Test
    void clickAllClearButton() throws InterruptedException{
        MealAndCaloriePage mealAndCaloriePage = new MealAndCaloriePage(driver);

        mealAndCaloriesInputForASingleMeal();
        //click 'add meal' button
        mealAndCaloriePage.clickOnAddMealButton();
        //wait for interactions
        Thread.sleep(3000);
        //click 'all clear' button
        mealAndCaloriePage.clickAllClearButton();
        System.out.println("The clear button was clicked");

    }

    //close
    @AfterEach
    void close () throws InterruptedException{
        Thread.sleep(5500);
        driver.quit();
    }


}
