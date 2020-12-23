package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Two common steps to invoke the Chrome browser
        //Setting the Properties and the Path
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");

        // Initialize browser
        WebDriver driver = new ChromeDriver();
        int j = 0;
        //How to handle when they ask you to find multiple product names?
        //Declare an Array in java
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);

//Sending Array of Product to Cart for checkout
        //Selecting all the matching Product lists from the cssSelector
//Return type for findElement is WebElements = to return a list is List<WebElement>
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        //Iterate through the Products (Loop)
        for (int i = 0; i < products.size(); i++)

            //iterate to each and every index
        {
            //Get one index out of the 30
            //Store it in a variable
            String[] name = products.get(i).getText().split("-"); //To get the text present on the product cart
            String formattedName = name[0].trim(); //Method trim in Java removes all the white spaces.
            //format it to get actual vegetable name, pass it to the 'if condition' to check your array

            //Convert array into array list for easy search (Is to save the memory)
            //Check whether name you extracted is present in array or not
            // Conversion of array to ArrayList
            // using Arrays.asList
            List itemsNeededList = Arrays.asList(itemsNeeded);

            //if Loop
            if (itemsNeededList.contains(formattedName)) {
                j++;
                //click on add to cart
                driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click();
                //End the for loop abruptly
//                break;
                //For the 'if statement' to be Generic
                if(j == itemsNeeded.length)
                {
                    break;
                }

            }
        }
    }
}
