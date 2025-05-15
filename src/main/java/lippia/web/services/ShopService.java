package lippia.web.services;

import com.crowdar.driver.DriverManager;
import lippia.web.constants.ShopConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.crowdar.core.actions.ActionManager.getElement;

public class ShopService {

    public static void clickOnCategory(String category) {
        String locator;

        switch (category.toLowerCase()) {
            case "android":
                locator = ShopConstants.ANDROID_CATEGORY;
                break;
            case "html":
                locator = ShopConstants.HTML_CATEGORY;
                break;
            case "javascript":
                locator = ShopConstants.JAVASCRIPT_CATEGORY;
                break;
            case "selenium":
                locator = ShopConstants.SELENIUM_CATEGORY;
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }

        WebElement element = getElement(locator);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }

    public static void clickOnHome() {
        WebElement element = getElement(ShopConstants.HOME_MENU_BUTTON);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);

    }

    public static void clickOnFilter(String filterVisibleText) {
        Select dropdown = new Select(getElement(ShopConstants.DEFAULT_SORTING_DROPDOWN));
        dropdown.selectByVisibleText(filterVisibleText);
    }

    private static final Map<String, Consumer<List<WebElement>>> VALIDATION_STRATEGIES = new HashMap<>();

    static {
        VALIDATION_STRATEGIES.put("popular", ShopService::verificarPopularidad);
        VALIDATION_STRATEGIES.put("rating", ShopService::verificarRating);
        VALIDATION_STRATEGIES.put("new", ShopService::verificarFechas);
        VALIDATION_STRATEGIES.put("low to high", ShopService::verificarPreciosAsc);
        VALIDATION_STRATEGIES.put("high to low", ShopService::verificarPreciosDesc);
    }

    public static void verifyFilteredProducts(String validationKey) {
        List<WebElement> productElements = DriverManager.getDriverInstance()
                .findElements(By.xpath(ShopConstants.PRODUCT_LIST));

        Consumer<List<WebElement>> strategy = VALIDATION_STRATEGIES.get(validationKey);
        if (strategy == null) {
            throw new IllegalArgumentException("No validation strategy for: " + validationKey);
        }

        strategy.accept(productElements);
    }


    private static void verificarPreciosAsc(List<WebElement> productos) {
        List<Double> precios = productos.stream()
                .map(e -> e.findElement(By.xpath(".//span[@class='price']//span[@class='woocommerce-Price-amount amount']"))
                        .getText().replaceAll("[^\\d.]", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> ordenado = new ArrayList<>(precios);
        Collections.sort(ordenado);
        System.out.println("Lista de precios extraída: " + precios);
        System.out.println("Lista ordenada esperada: " + ordenado);
        Assert.assertEquals(precios, ordenado, "Los precios no están en orden ascendente");
    }

    private static void verificarPreciosDesc(List<WebElement> productos) {
        List<Double> precios = productos.stream()
                .map(e -> e.findElement(By.xpath(".//span[@class='price']//span[@class='woocommerce-Price-amount amount']"))
                        .getText().replaceAll("[^\\d.]", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> ordenado = new ArrayList<>(precios);
        ordenado.sort(Collections.reverseOrder());
        System.out.println("Lista de precios extraída: " + precios);
        System.out.println("Lista ordenada esperada: " + ordenado);

        Assert.assertEquals(precios, ordenado, "Los precios no están en orden descendente");
    }

    private static void verificarPopularidad(List<WebElement> productos) {
        if (!productos.isEmpty()) {
            try {
                WebElement popularidadElement = productos.get(0).findElement(By.xpath(".//img[@alt='Android Quick Start Guide']"));
                Assert.assertTrue(popularidadElement.isDisplayed(), "El indicador de popularidad está presente en el primer producto.");
            } catch (NoSuchElementException e) {
                Assert.fail("No se encontró el indicador de popularidad en el primer producto: " + e.getMessage());
            }
        } else {
            Assert.fail("No se encontraron productos para verificar la popularidad.");
        }
    }

    private static void verificarRating(List<WebElement> productos) {
        if (!productos.isEmpty()) {
            try {
                WebElement ratingElement = productos.get(0).findElement(By.xpath(".//img[@alt='Selenium Ruby']"));
                Assert.assertTrue(ratingElement.isDisplayed(), "El rating está presente en el primer producto.");
            } catch (NoSuchElementException e) {
                Assert.fail("No se encontró el elemento de rating en el primer producto: " + e.getMessage());
            }
        } else {
            Assert.fail("No se encontraron productos para verificar el rating.");
        }
    }

    private static void verificarFechas(List<WebElement> productos) {
        if (!productos.isEmpty()) {
            try {
                WebElement fechaElement = productos.get(0).findElement(By.xpath(".//h3[text()='HTML5 WebApp Develpment']"));
                Assert.assertTrue(fechaElement.isDisplayed(), "La fecha está presente en el primer producto.");
            } catch (NoSuchElementException e) {
                Assert.fail("No se encontró el elemento de fecha en el primer producto: " + e.getMessage());
            }
        } else {
            Assert.fail("No se encontraron productos para verificar la fecha.");
        }
    }
}


